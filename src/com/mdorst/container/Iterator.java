package com.mdorst.container;

/**
 * Michael Dorst
 */

/**
 * ListIteratorBase
 * + get() : T
 * + next() : T
 * + prev() : T
 * + hasNext() : Boolean
 * + hasPrev() : Boolean
 */

public abstract class Iterator<T> {
    public abstract T get();
    public abstract T next();
    public abstract T prev();
    public abstract boolean hasNext();
    public abstract boolean hasPrev();
}
