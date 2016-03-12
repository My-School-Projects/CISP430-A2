package com.mdorst.container.list;

public class SortedList<E extends Comparable<? super E>> extends LinkedList<E> {
    @Override
    public boolean add(E e) {
        size++;
        Node<E> node = new Node<>(e);
        for (Node<E> n = head.next; n != head; n = n.next) {
            if (e.compareTo(n.data) < 0) {
                n.prev.next = node;
                node.prev = n.prev;
                n.prev = node;
                node.next = n;
                return true;
            }
        }
        head.prev.next = node;
        node.prev = head.prev;
        head.prev = node;
        node.next = head;
        return true;
    }
}
