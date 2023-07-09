package com.example.design.pattern.factory;


public class FactoryMethodPattern {

    private Dialog dialog;

    public static void main(String[] args) {
        var fmm = new FactoryMethodPattern();
        String web = "Web";
        fmm.initialization(web);
        fmm.dialog.render();
    }

    void initialization(String os) {

        if (os.equals("Windows")) {
            dialog = new WindowsDialog();
        } else if (os.equals("Web")) {
            dialog = new WebDialog();
        } else {
            throw new IllegalArgumentException("Not exist");
        }

    }

    // TODO Dialog class
    private static abstract class Dialog {
        abstract Button createButton();

        void render() {
            Button button = createButton();
            button.onClick();
            button.render();
        }
    }

    private static class WindowsDialog extends Dialog {
        @Override
        Button createButton() {
            return new WindowsButton();
        }
    }


    private static class WebDialog extends Dialog {
        @Override
        Button createButton() {
            return new WindowsButton();
        }
    }


    //TODO Button Class
    private interface Button {
        void render();

        void onClick();
    }

    private static class WindowsButton implements Button {

        @Override
        public void render() {
            System.out.println("Windows Button is rendered");
        }

        @Override
        public void onClick() {
            System.out.println("Windows Button is clicked");
        }
    }

    private static class HTMLButton implements Button {

        @Override
        public void render() {
            System.out.println("HTMLButton Button is rendered");
        }

        @Override
        public void onClick() {
            System.out.println("HTMLButton Button is clicked");
        }
    }
}

