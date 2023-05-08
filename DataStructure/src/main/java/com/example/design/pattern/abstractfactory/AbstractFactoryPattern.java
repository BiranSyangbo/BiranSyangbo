package com.example.design.pattern.abstractfactory;

public class AbstractFactoryPattern {

    private GuiFactory factory;

    public static void main(String[] args) {
        var af = new AbstractFactoryPattern();
        String os = "W";
        af.initialization(os);
        af.factory.createButton().paint();
        af.factory.createCheckBox().paint();
    }

    private void initialization(String os) {
        if (os.equals("L")) {
            factory = new LinuxFactory();
        } else if (os.equals("M")) {
            factory = new MacFactory();
        } else if (os.equals("W")) {
            factory = new WinFactory();
        } else {
            throw new IllegalArgumentException("Os is not found");
        }

    }

    private interface GuiFactory {
        Button createButton();

        CheckBox createCheckBox();
    }

    private static class LinuxFactory implements GuiFactory {
        @Override
        public Button createButton() {
            return new LinuxButton();
        }

        @Override
        public CheckBox createCheckBox() {
            return new LinuxCheckBox();
        }
    }

    private static class MacFactory implements GuiFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public CheckBox createCheckBox() {
            return new MacCheckBox();
        }
    }

    private static class WinFactory implements GuiFactory {
        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public CheckBox createCheckBox() {
            return new WinCheckBox();
        }
    }

    private interface Button {
        void paint();
    }

    private interface CheckBox {
        void paint();
    }

    private static class LinuxButton implements Button {
        @Override
        public void paint() {
            System.out.println("Linux Button color");
        }
    }

    private static class MacButton implements Button {
        @Override
        public void paint() {
            System.out.println("Mac Button color");
        }
    }

    private static class LinuxCheckBox implements CheckBox {
        @Override
        public void paint() {
            System.out.println("Linux Checkbox paint");
        }

    }

    private static class MacCheckBox implements CheckBox {
        @Override
        public void paint() {
            System.out.println("Mac Checkbox Paint");
        }
    }

    private static class WinButton implements Button {
        @Override
        public void paint() {
            System.out.println("Windows Button paint");
        }
    }

    private static class WinCheckBox implements CheckBox {
        @Override
        public void paint() {
            System.out.println("Win CheckBox Paint");
        }
    }
}
