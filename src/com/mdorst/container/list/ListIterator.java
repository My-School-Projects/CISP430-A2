package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * ListIterator
 * - node : Node
 *
 * + get() : T
 * + next() : T
 * + prev() : T
 * + hasNext() : Boolean
 * + hasPrev() : Boolean
 * ~ constructor(Node)
 */

public class ListIterator<T> extends ListIteratorBase<T> {
    @Override
    public T get() {
        return super.get();
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

    @Override
    public ListIterator<T> copy() {
        return (ListIterator<T>) super.copy();
    }

    ListIterator(Node<T> node) {
        super(node);
    }
}
