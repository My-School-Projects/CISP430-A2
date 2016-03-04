package com.mdorst.container.list;

/**
 * Michael Dorst
 */

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * T : Generic
 *
 * Predicate : (Function(T, T) : Boolean)
 * Block : Function(T)
 * UnaryOperator : (Function(T) : T)
 *
 * ListBase
 * - front : Node
 * - back : Node
 * - size : Integer
 *
 * + size() : Integer
 * # insert(Node, Integer)
 * # deleteAll(T)
 * # pushFront(T)
 * # pushBack(T)
 * # delete(Integer)
 * # popFront() : T
 * # popBack() : T
 * - getNode(Integer) : Node
 */

class ListBase<T> {
    protected Node<T> front, back;
    protected int size;

    public int size() {
        return size;
    }

    protected void pushFront(T obj) {
        if (size() == 0) {
            front = back = new Node<>(obj);
        } else {
            front.insertPrev(new Node<>(obj));
            front = front.prev;
        }
        size++;
    }

    protected void pushBack(T obj) {
        if (size() == 0) {
            front = back = new Node<>(obj);
        } else {
            back.insertNext(new Node<>(obj));
            back = back.next;
        }
        size++;
    }

    protected T popFront() {
        Node<T> node = front;
        front = front.next;
        node.delete();
        return node.data;
    }

    protected T popBack() {
        Node<T> node = back;
        back = back.prev;
        node.delete();
        return node.data;
    }

    protected Node<T> getNode(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node;
        if (index < size / 2) {
            node = front;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = back;
            for (int i = size-1; i > 0; i++) {
                node = node.prev;
            }
        }
        return node;
    }
}
