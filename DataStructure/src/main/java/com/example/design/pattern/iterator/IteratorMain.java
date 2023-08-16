package com.example.design.pattern.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record IteratorMain(String text) {

    public static void main(String[] args) {
//        new IteratorMain("TEst on going").test()
//        .test();


        Object[] obj = new Object[3];
        obj[0] = 1;
        obj[1] = "Ok";
        obj[2] = true;

        TreeIterator treeIterator = new TreeIteratorImpl(obj);
        IteratorInterface dfsTreeIterator = treeIterator.dfsTreeIterator();
        while (dfsTreeIterator.hasNext()) {
            System.out.println(dfsTreeIterator.next());
        }
        System.out.println();
        var bfsTreeIterator = treeIterator.bfsTreeIterator();
        while (bfsTreeIterator.hasNext()) {
            System.out.println(bfsTreeIterator.next());
        }

    }

    public Test test() {
        return new Test();
    }

    public void print() {
        var s = IteratorMain.this.text;
        System.out.println(s);
    }

    class Test {
        void test() {
            IteratorMain.this.print();
        }
    }
}
