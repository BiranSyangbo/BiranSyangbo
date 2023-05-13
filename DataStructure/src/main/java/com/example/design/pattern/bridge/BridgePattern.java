package com.example.design.pattern.bridge;

import lombok.ToString;

public class BridgePattern {

    public static void main(String[] args) {
        var tv = new TV();
        var remoteControl = new RemoteControl(tv);
        remoteControl.increaseChannel();
        remoteControl.togglePower();
        remoteControl.upVolume();
        remoteControl.downVolume();
        remoteControl.downVolume();
        System.out.println(remoteControl);
    }

    private static class RemoteControl {
        protected final Device device;

        private RemoteControl(Device device) {
            this.device = device;
        }

        void togglePower() {
            if (device.isEnabled()) {
                device.disable();
            } else {
                device.enable();
            }
        }

        void upVolume() {
            device.setVolume(device.getVolume() + 10);
        }

        void downVolume() {
            device.setVolume(device.getVolume() - 10);
        }

        void increaseChannel() {
            device.setChannel(device.getChannel() + 1);
        }

        void decreaseChannel() {
            device.setChannel(device.getChannel() - 1);
        }

        @Override
        public String toString() {
            return "RemoteControl{" +
                    "device=" + device +
                    '}';
        }
    }

    private final static class AdvanceController extends RemoteControl {


        private AdvanceController(Device device) {
            super(device);
        }

        void mute() {
            this.device.setVolume(0);
        }
    }

    private sealed interface Device permits TV, Radio {
        boolean isEnabled();

        void enable();

        void disable();

        int getVolume();

        void setVolume(int volume);

        int getChannel();

        void setChannel(int channel);
    }

    @ToString
    private static final class TV implements Device {

        boolean enable;
        int volume;
        int channel;

        @Override
        public boolean isEnabled() {
            return enable;
        }

        @Override
        public void enable() {
            this.enable = Boolean.TRUE;
        }

        @Override
        public void disable() {
            this.enable = Boolean.FALSE;
        }

        @Override
        public int getVolume() {
            return volume;
        }

        @Override
        public void setVolume(int volume) {
            if (volume < 0)
                volume = 0;
            else if (volume > 100)
                volume = 100;
            this.volume = volume;
        }

        @Override
        public int getChannel() {
            return this.channel;
        }

        @Override
        public void setChannel(int channel) {
            this.channel = channel;
        }
    }

    @ToString
    private static final class Radio implements Device {
        boolean enable;
        int volume;
        int channel;

        @Override
        public boolean isEnabled() {
            return enable;
        }

        @Override
        public void enable() {
            this.enable = Boolean.TRUE;
        }

        @Override
        public void disable() {
            this.enable = Boolean.FALSE;
        }

        @Override
        public int getVolume() {
            return volume;
        }

        @Override
        public void setVolume(int volume) {
            if (volume < 0)
                volume = 0;
            else if (volume > 100)
                volume = 100;
            this.volume = volume;
        }

        @Override
        public int getChannel() {
            return this.channel;
        }

        @Override
        public void setChannel(int channel) {
            this.channel = channel;
        }
    }
}
