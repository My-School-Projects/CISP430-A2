package com.mdorst.container.list;

public class PriorityQueue<E extends Comparable<? super E>> extends SortedList<E> {
    public void enqueue(E e) {
        add(e);
    }

    public E dequeue() {
        Node<E> r = head.prev;
        r.delete();
        return r.data;
    }
}
