package com.example.design.pattern.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BuilderPattern {

    public static void main(String[] args) {
        var bp = new BuilderPattern();
        var carBuilder = new CarBuilder();
        bp.constructCar(carBuilder);
        System.out.println(carBuilder.getResult());
        var manualBuilder = new CarManualBuilder();
        bp.constructManual(manualBuilder);
        System.out.println(manualBuilder.getResult());
    }

    void constructCar(Builder builder) {
        builder.setEngine(1);
        builder.setGps(1.2f, 1.3f);
        builder.setSeats(4);
        builder.setTripComputer(2);
    }

    void constructManual(Builder builder) {
        builder.setEngine(1);
        builder.setGps(1.2f, 1.3f);
        builder.setSeats(4);
        builder.setTripComputer(2);
    }


    private interface Builder {
        void reset();

        void setSeats(int number);

        void setEngine(int engine);

        void setTripComputer(int tripComputer);

        void setGps(float lat, float lan);
    }

    private static class CarBuilder implements Builder {

        private Car car;

        public CarBuilder() {
            car = new Car();
        }

        @Override
        public void reset() {
            car = new Car();
        }

        @Override
        public void setSeats(int number) {
            car.setSeats(number);
        }

        @Override
        public void setEngine(int engine) {
            car.setEngine(engine);
        }

        @Override
        public void setTripComputer(int tripComputer) {
            car.setTripComputer(tripComputer);
        }

        @Override
        public void setGps(float lat, float lan) {
            car.setLan(lan);
            car.setLat(lat);
        }

        public Car getResult() {
            return car;
        }
    }

    private static class CarManualBuilder implements Builder {

        private Manual manual;

        public CarManualBuilder() {
            manual = new Manual();
        }

        @Override
        public void reset() {
            manual = new Manual();
        }

        @Override
        public void setSeats(int number) {
            manual.setSeats(number);
        }

        @Override
        public void setEngine(int engine) {
            manual.setEngine(engine);
        }

        @Override
        public void setTripComputer(int tripComputer) {
            manual.setTripComputer(tripComputer);
        }

        @Override
        public void setGps(float lat, float lan) {
            manual.setLan(lan);
            manual.setLat(lat);
        }

        public Manual getResult() {
            return manual;
        }
    }

    @Setter
    @Getter
    @ToString
    private static class Car {
        private int seats;
        private int engine;
        private int tripComputer;
        private float lat;
        private float lan;
    }

    @Setter
    @Getter
    @ToString
    private static class Manual {
        private int seats;
        private int engine;
        private int tripComputer;
        private float lat;
        private float lan;
    }
}
