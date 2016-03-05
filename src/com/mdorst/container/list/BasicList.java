package com.mdorst.container.list;

/*
 * T : Generic
 *
 * BasicList
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

import java.util.Objects;

/**
 * This class provides all of the methods common
 * to the List, Stack and Queue classes.
 *
 * @param <T> the type of the elements held in this collection
 */
class BasicList<T> {
    protected Node<T> front, back;
    protected int size;

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "[";
        Node<T> n = front;
        while (n != null) {
            if (!Objects.equals(s, "[")) s += ", ";
            s += n.data.toString();
            n = n.next;
        }
        return s + "]";
    }

    /**
     * Adds an element to the front of the list
     *
     * @param obj the element to be added
     */
    protected void pushFront(T obj) {
        if (size() == 0) {
            front = back = new Node<>(obj);
        } else {
            front.insertPrev(new Node<>(obj));
            front = front.prev;
        }
        size++;
    }

    /**
     * Adds an element to the back of the list
     *
     * @param obj the element to be added
     */
    protected void pushBack(T obj) {
        if (size() == 0) {
            front = back = new Node<>(obj);
        } else {
            back.insertNext(new Node<>(obj));
            back = back.next;
        }
        size++;
    }

    /**
     * Removes an element from the front of the list, returning it to the caller
     *
     * @return the removed element
     */
    protected T popFront() {
        Node<T> node = front;
        front = front.next;
        node.delete();
        size--;
        return node.data;
    }

    /**
     * Removes an element from the back of the list, returning it to the caller
     *
     * @return the removed element
     */
    protected T popBack() {
        Node<T> node = back;
        back = back.prev;
        node.delete();
        size--;
        return node.data;
    }

    /**
     * Seek through the list until {@code index} is reached, then return
     * the {@code Node} at that index
     *
     * @param index the index of the {@code Node} to be returned
     * @return the {@code Node} located at {@code index}
     */
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

    public BasicList(BasicList<T> other) {
        if (other.size() > 0) {
            Node<T> n = other.front;
            Node<T> o = front = new Node<>(n.data);
            n = n.next;
            while (n != null) {
                Node<T> p = new Node<>(n.data);
                o.next = p;
                p.prev = o;
                o = p;
                n = n.next;
            }
            back = o;
        }
    }

    public BasicList() {}
}
