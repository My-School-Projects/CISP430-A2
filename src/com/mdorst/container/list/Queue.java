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
 * + iterator() : ListIterator
 * + constructor()
 * + constructor(ListBase)
 */

public class Queue<T> extends SortableList<T> {
    public void enqueue(T obj) {
        super.pushFront(obj);
    }

    public T dequeue() {
        return super.popBack();
    }
}
