package com.example.design.pattern.iterator;

public class DfsIterator implements IteratorInterface {


    Object[] objectList;

    int cursor = 0;
    int size = 0;

    public DfsIterator(Object[] objectList) {
        System.out.println("Dfs Tree");
        this.size = objectList.length;
        this.objectList = objectList;
    }

    // should be implemented the depth first search but for the clear the concept using the normal iterator
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
