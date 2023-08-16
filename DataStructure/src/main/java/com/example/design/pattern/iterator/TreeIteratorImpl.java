package com.example.design.pattern.iterator;

public class TreeIteratorImpl implements TreeIterator {

    Object[] objects;

    public TreeIteratorImpl(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public IteratorInterface dfsTreeIterator() {
        return new DfsIterator(objects);
    }

    @Override
    public IteratorInterface bfsTreeIterator() {
        return new BfsIterator(objects);
    }
}
