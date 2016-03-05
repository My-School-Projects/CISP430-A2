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
 * @param <E> the type of the elements held in this collection
 */
public class Queue<E extends Comparable<? super E>> extends SortableList<E> {

    /**
     * Adds an element at the front of the collection
     *
     * @param obj the element to be added
     */
    public void enqueue(E obj) {
        super.pushBack(obj);
    }

    /**
     * Removes an element from the back of the collection, returning it to the caller
     *
     * @return the removed element
     */
    public E dequeue() {
        return super.popFront();
    }

    public Queue(BasicList<E> other) {
        super(other);
    }

    public Queue() {}
}
