package com.example.design.pattern.builder;

import lombok.Builder;
import lombok.ToString;

@Builder
public class BuilderPatter2 {

    public static void main(String[] args) {
        Car car = Car.builder()
                .setEngine(100_000)
                .build();
        System.out.println(car);
    }

    private record Car(int seats, int engine, int tripComputer, float lat, float lan) {

        static CarBuilder builder() {
            return new CarBuilder();
        }

        private static class CarBuilder {

            private int seats;
            private int engine;
            private int tripComputer;
            private float lat;
            private float lan;


            public CarBuilder setSeats(int seats) {
                this.seats = seats;
                return this;
            }

            public CarBuilder setEngine(int engine) {
                this.engine = engine;
                return this;
            }

            public CarBuilder setTripComputer(int tripComputer) {
                this.tripComputer = tripComputer;
                return this;
            }

            public CarBuilder setLat(float lat) {
                this.lat = lat;
                return this;
            }

            public CarBuilder setLan(float lan) {
                this.lan = lan;
                return this;
            }

            Car build() {
                return new Car(this.seats, this.engine, this.tripComputer, this.lat, this.lan);
            }
        }
    }
}
