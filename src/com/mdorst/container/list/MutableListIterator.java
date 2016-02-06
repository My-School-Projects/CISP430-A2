package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * MutableListIterator
 * - node : Node
 *
 * + get() : T
 * + set(T)
 * + next() : T
 * + prev() : T
 * ~ constructor(Node)
 */

public class MutableListIterator<T> extends ListIteratorBase<T> {
    @Override
    public T get() {
        return super.get();
    }

    @Override
    public void set(T data) {
        super.set(data);
    }

    @Override
    public T next() {
        return super.next();
    }

    @Override
    public T prev() {
        return super.prev();
    }

    MutableListIterator(Node<T> node) {
        super(node);
    }
}
