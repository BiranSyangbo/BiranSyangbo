//package com.example.design.pattern.adaptor;
//
//public class AdaptorPattern {
//
//    public static void main(String[] args) {
//        var roundHole = new RoundHole(5);
//        var roundPeg = new RoundPeg(5);
//        if (roundHole.fit(roundPeg))
//            System.out.println("Round Peg is fit on Round Hole");
//        var smallSquarePeg = new SquarePeg(5);
//        var largeSquarePeg = new SquarePeg(6);
//        var smallSquarePegAdaptor = new SquirePegAdaptor(smallSquarePeg);
//        if (roundHole.fit(smallSquarePegAdaptor)) {
//            System.out.println("Small Square peg is fit on round hole");
//        }
//        var largeSquarePegAdaptor = new SquirePegAdaptor(largeSquarePeg);
//        System.out.println(largeSquarePegAdaptor.radius());
//        if (roundHole.fit(largeSquarePegAdaptor)) {
//            System.out.println("Large Square Peg is fit on round hole");
//        } else {
//            System.out.println("Large Square Peg doesn't" +
//                    " fit on round hole");
//        }
//
//
//    }
//
//    private record RoundHole(double radius) {
//
//        boolean fit(RoundPeg peg) {
//            return peg.radius() <= this.radius();
//        }
//    }
//
//    private static sealed class RoundPeg permits SquirePegAdaptor {
//        private final double radius;
//
//        RoundPeg(double radius) {
//            this.radius = radius;
//        }
//
//        double radius() {
//            return this.radius;
//        }
//    }
//
//    private record SquarePeg(int width) {
//    }
//
//
//    private static final class SquirePegAdaptor extends RoundPeg {
//        private SquarePeg peg;
//
//        private SquirePegAdaptor(SquarePeg peg) {
//            super(0);
//            this.peg = peg;
//        }
//
//        @Override
//        double radius() {
//            return (Math.sqrt(Math.pow(((double) peg.width() / 2), 2) * 2));
//        }
//    }
//
//}
