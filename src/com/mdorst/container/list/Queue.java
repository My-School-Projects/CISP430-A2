package com.mdorst.container.list;

/**
 * Michael Dorst
 */

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Queue is a ListBase
 *
 * T : Generic
 *
 * Block : Function(T)
 * Predicate : (Function(T, T) : Boolean)
 *
 * Queue
 * + enqueue(T)
 * + dequeue() : T
 * + sort(Predicate)
 * + search(T, Predicate) : Boolean
 * + iterate(Block)
 * + mutableIterator() : MutableListIterator
 * + iterator() : ListIterator
 * + constructor()
 * + constructor(ListBase)
 */

public class Queue<T> extends ListBase<T> {
    public void enqueue(T obj) {
        super.pushFront(obj);
    }

    public T dequeue() {
        return super.popBack();
    }

    @Override
    public ListIterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public boolean search(T key) {
        return super.search(key);
    }

    @Override
    public void sort(Comparator<T> c) {
        super.sort(c);
    }

    @Override
    public void iterate(Consumer<T> block) {
        super.iterate(block);
    }
}
