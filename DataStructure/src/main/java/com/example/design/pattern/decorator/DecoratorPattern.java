package com.example.design.pattern.decorator;

import java.io.*;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DecoratorPattern {

    public static void main(String[] args) throws IOException {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        var encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("salary.txt")));
        encoded.writeData(salaryRecords);
        System.out.println(encoded.readData());
    }

    private interface DataSource {
        void writeData(String data) throws IOException;

        String readData();
    }

    private record FileDataSource(String fileName) implements DataSource {

        @Override
            public void writeData(String data) throws IOException {
                File file = new File(fileName);
                if(!file.exists())
                    file.createNewFile();
                try (var outputStream = new FileOutputStream(file)) {
                    outputStream.write(data.getBytes(), 0, data.length());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String readData() {
                char[] buffer;
                File file = new File(fileName);
                try (var reader = new FileReader(file)) {
                    buffer = new char[(int) file.length()];
                    int val = reader.read(buffer);
                    System.out.println(val);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return new String(buffer);
            }
        }

    private static class DataSourceDecorator implements DataSource {

        private final DataSource wrapper;

        public DataSourceDecorator(DataSource wrapper) {
            this.wrapper = wrapper;
        }

        @Override
        public void writeData(String data) throws IOException {
            wrapper.writeData(data);
        }

        @Override
        public String readData() {
            return wrapper.readData();
        }
    }

    private static final class EncryptionDecorator extends DataSourceDecorator {

        EncryptionDecorator(DataSource wrapper) {
            super(wrapper);
        }

        @Override
        public void writeData(String data) throws IOException {
            super.writeData(encode(data));
        }

        @Override
        public String readData() {
            return decode(super.readData());
        }

        private String encode(String data) {
            return Base64.getEncoder().encodeToString(data.getBytes());
        }

        private String decode(String encode) {
            return new String(Base64.getDecoder().decode(encode));
        }

    }

    private static final class CompressionDecorator extends DataSourceDecorator {

        public CompressionDecorator(DataSource wrapper) {
            super(wrapper);
        }

        @Override
        public void writeData(String data) throws IOException {
            super.writeData(compress(data));
        }

        @Override
        public String readData() {
            return decompress(super.readData());
        }

        private String compress(String data) {
            try (var outputStream = new ByteArrayOutputStream(512)) {
                var zip = new GZIPOutputStream(outputStream);
                zip.write(data.getBytes());
                zip.close();
                outputStream.close();
                return Base64.getEncoder().encodeToString(outputStream.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private String decompress(String data) {
            byte[] decode = Base64.getDecoder().decode(data);
            try (var in = new ByteArrayInputStream(decode, 0, decode.length)) {
                var zip = new GZIPInputStream(in);
                var bout = new ByteArrayOutputStream(512);
                int b;
                while ((b = in.read()) != -1) {
                    bout.write(b);
                }
                in.close();
                zip.close();
                bout.close();
                return bout.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
