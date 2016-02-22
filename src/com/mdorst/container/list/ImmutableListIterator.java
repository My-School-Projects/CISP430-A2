package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * ImmutableListIterator
 * - node : Node
 *
 * + get() : T
 * + next() : T
 * + prev() : T
 * + hasNext() : Boolean
 * + hasPrev() : Boolean
 * ~ constructor(Node)
 */

public class ImmutableListIterator<T> extends ListIteratorBase<T> {
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
    public ImmutableListIterator<T> copy() {
        return (ImmutableListIterator<T>) super.copy();
    }

    ImmutableListIterator(Node<T> node) {
        super(node);
    }
}
