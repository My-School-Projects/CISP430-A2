package com.mdorst.container.list;

/**
 * Michael Dorst
 */

import com.mdorst.container.Iterator;

/**
 * ListIteratorBase
 * - node : Node
 *
 * + get() : T
 * + next() : T
 * + prev() : T
 * + hasNext() : Boolean
 * + hasPrev() : Boolean
 * # set(T)
 * # constructor(Node)
 */

class ListIteratorBase<T> extends Iterator<T> {
    private Node<T> node;

    @Override
    public T get() {
        return node.data;
    }

    protected void set(T data) {
        node.data = data;
    }

    @Override
    public T next() {
        return (node = node.next).data;
    }

    @Override
    public T prev() {
        return (node = node.prev).data;
    }

    @Override
    public boolean hasNext() {
        return node.next != null;
    }

    @Override
    public boolean hasPrev() {
        return node.prev != null;
    }

    protected ListIteratorBase(Node<T> node) {
        this.node = node;
    }
}