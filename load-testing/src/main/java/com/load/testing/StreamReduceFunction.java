package com.load.testing;

import java.util.stream.Stream;

public class StreamReduceFunction {

    public static void main(String[] args) {
        Integer reduce = Stream.of(1, 10, 3)
                .reduce(0, (integer, integer2) -> {
                    System.out.println("1: " + integer + "  " + integer2);
                    return integer;
                }, (integer, integer2) -> {
                    System.out.println("2: " + integer + "  " + integer2);
                    return integer + integer2;
                });

        StreamReduceFunction streamReduceFunction = new StreamReduceFunction();
        streamReduceFunction.sum(streamReduceFunction.getTest());
    }

    public int sum(Test test) {
        return test.sum(1,2);
    }

    private Test getTest() {
       return (a, b) -> a + b;
    };
}

interface Test {
    int sum(int a, int b);
}
