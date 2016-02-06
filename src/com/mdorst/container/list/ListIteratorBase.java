package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * ListIteratorBase
 * - node : Node
 *
 * # get() : T
 * # set(T)
 * # next() : T
 * # prev() : T
 * # constructor(Node)
 */

class ListIteratorBase<T> {
    private Node<T> node;

    protected T get() {
        return node.data;
    }

    protected void set(T data) {
        node.data = data;
    }

    protected T next() {
        return (node = node.next).data;
    }

    protected T prev() {
        return (node = node.prev).data;
    }

    protected ListIteratorBase(Node<T> node) {
        this.node = node;
    }
}
