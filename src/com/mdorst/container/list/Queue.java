package com.mdorst.container.list;

/*
 * Queue is a SortableList
 *
 * T : Generic
 *
 * Queue
 * + enqueue(T)
 * + dequeue() : T
 */

/**
 * This class extends SortableList, and provides methods to support
 * a FIFO queue pattern.
 *
 * @param <T> the type of the elements held in this collection
 */
public class Queue<T> extends SortableList<T> {

    /**
     * Adds an element at the front of the collection
     *
     * @param obj the element to be added
     */
    public void enqueue(T obj) {
        super.pushFront(obj);
        super.pushBack(obj);
    }

    /**
     * Removes an element from the back of the collection, returning it to the caller
     *
     * @return the removed element
     */
    public T dequeue() {
        return super.popBack();
    }

    Queue(BasicList<T> other) {
        super(other);
    }

    Queue() {}
}
