package com.example.design.pattern.iterator;

import java.util.List;

public class BfsIterator implements IteratorInterface {

    Object[] objectList;

    int size;
    int cursor;

    public BfsIterator(Object[] objectList) {
        System.out.println("Bfs Tree");
        this.size = objectList.length;
        this.objectList = objectList;
    }

    // should be implemented the breadth first search but for the clear the concept using the normal iterator
    @Override
    public Object next() {
        int i = cursor;
        cursor = i + 1;
        return objectList[i];
    }

    @Override
    public boolean hasNext() {
        return this.size > cursor;
    }
}
