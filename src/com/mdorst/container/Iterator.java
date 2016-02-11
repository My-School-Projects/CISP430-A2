package com.mdorst.container;

/**
 * Michael Dorst
 */

/**
 * Iterator
 * + get() : T
 * + next() : T
 * + prev() : T
 * + hasNext() : Boolean
 * + hasPrev() : Boolean
 * + swap(Iterator)
 * + copy() : Iterator
 */

public interface Iterator<T> {
    public T get();
    public T next();
    public T prev();
    public boolean hasNext();
    public boolean hasPrev();
    public void swap(Iterator<T> it);
    public Iterator<T> copy();
}
