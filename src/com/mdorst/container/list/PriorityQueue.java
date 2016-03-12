package com.mdorst.container.list;

public class PriorityQueue<E extends Comparable<? super E>> extends SortedList<E> {

    public PriorityQueue(LinkedList<E> other) {
        super(other);
    }

    public PriorityQueue() {}

    public void enqueue(E e) {
        add(e);
    }

    public E dequeue() {
        E value = head.next.data;
        head.next.delete();
        return value;
    }

    public E front() {
        return head.next.data;
    }
}
