package com.mdorst.container.list;

public class SortedList<E extends Comparable<? super E>> extends LinkedList<E> {
    @Override
    public boolean add(E e) {
        size++;
        for (Node<E> n = head.next; n != head; n = n.next) {
            if (e.compareTo(n.data) < 0) {
                n.insertPrev(new Node<>(e));
                return true;
            }
        }
        head.insertPrev(new Node<>(e));
        return true;
    }
}
