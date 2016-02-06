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

    ImmutableListIterator(Node<T> node) {
        super(node);
    }
}
