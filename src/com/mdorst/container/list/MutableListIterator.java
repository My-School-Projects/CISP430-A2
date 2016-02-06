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
 * + hasNext() : Boolean
 * + hasPrev() : Boolean
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

    @Override
    public boolean hasNext() {
        return super.hasNext();
    }

    @Override
    public boolean hasPrev() {
        return super.hasPrev();
    }

    MutableListIterator(Node<T> node) {
        super(node);
    }
}
