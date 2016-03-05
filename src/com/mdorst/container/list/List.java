package com.mdorst.container.list;

import java.util.Objects;

/*
 * List is a SortableList
 *
 * T : Generic
 *
 * Predicate : (Function(T, T) : Boolean)
 * Block : Function(T)
 * UnaryOperator : (Function(T) : T)
 *
 * List
 * + insert(Node, Integer)
 * + get(Integer) : T
 * + delete(Integer)
 * + delete(T)
 * + deleteAll(T)
 * + pushFront(T)
 * + pushBack(T)
 * + popFront() : T
 * + popBack() : T
 */

/**
 * This class extends SortableList, and provides facilities for use
 * as a list container.
 *
 * @param <T> the type of the elements held in this collection
 */
public class List<T extends Comparable<? super T>> extends SortableList<T> {

    /**
     * Insert {@code obj} into the collection
     * at the position specified by {@code index}
     * @param obj the element to be inserted
     * @param index the index at which to insert the element
     */
    public void insert(T obj, int index) {
        getNode(index).insertNext(new Node<T>(obj));
        size++;
    }

    /**
     * Return the element at the specified index
     *
     * @param index the index at which the desired element is located
     * @return the desired element
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * Remove the element at the specified index
     *
     * @param index the index at which the element to be deleted is located
     */
    public void delete(int index) {
        getNode(index).delete();
    }

    /**
     * Delete the first occurrence of {@code key} in the collection
     *
     * @param key the element to be removed
     */
    public void delete(T key) {
        for (Node<T> n = front; n.hasNext(); n = n.next) {
            if (Objects.equals(key, n.data)) {
                n.delete();
                return;
            }
        }
    }

    /**
     * Delete all occurrences of {@code key} in the collection
     *
     * @param key the element to be removed
     */
    public void deleteAll(T key) {
        for (Node<T> n = front; n.hasNext(); n = n.next) {
            if (Objects.equals(key, n.data)) {
                n.delete();
            }
        }
    }

    @Override
    public void pushFront(T obj) {
        super.pushFront(obj);
    }

    @Override
    public void pushBack(T obj) {
        super.pushBack(obj);
    }

    @Override
    public T popFront() {
        return super.popFront();
    }

    @Override
    public T popBack() {
        return super.popBack();
    }

    public List(BasicList<T> other) {
        super(other);
    }

    public List() {}
}
