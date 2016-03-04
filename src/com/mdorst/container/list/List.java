package com.mdorst.container.list;

/**
 * Michael Dorst
 */

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * List is a ListBase
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
 * + transform(UnaryOperator)
 * + pushFront(T)
 * + pushBack(T)
 * + popFront() : T
 * + popBack() : T
 */

public class List<T> extends SortableList<T> {

    /**
     * Insert <tt>obj</tt> into the collection
     * at the position specified by <tt>index</tt>
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
     * Delete the first occurrence of <tt>key</tt> in the collection
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
     * Delete all occurrences of <tt>key</tt> in the collection
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

    /**
     * Iterates over the collection, calling <tt>operator</tt> on each element,
     * and replacing each one with the value returned by <tt>operator</tt>
     *
     * @param operator the function to be called on each element
     */
    public void transform(UnaryOperator<T> operator) {
        Node<T> node = front;
        for (int i = 0; i < size(); i++) {
            node.data = operator.apply(node.data);
            node = node.next;
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
}
