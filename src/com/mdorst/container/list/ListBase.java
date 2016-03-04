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
 * # get(Integer) : T
 * # delete(T)
 * # deleteAll(T)
 * # pushFront(T)
 * # pushBack(T)
 * # delete(Integer)
 * # popFront() : T
 * # popBack() : T
 * # search(T) : Boolean
 * # sort(Predicate)
 * # immutableIterator() : ImmutableListIterator
 * # mutableIterator() : MutableListIterator
 * # iterate(Block)
 * # transform(UnaryOperator)
 * # search(T, Predicate) : Boolean
 * - getNode(Integer) : Node
 * + constructor()
 * + constructor(ListBase)
 */

class ListBase<T> {
    protected Node<T> front, back;
    protected int size;

    public int size() {
        return size;
    }

    protected T get(int index) {
        return getNode(index).data;
    }

    protected void delete(T key) {
        for (Node<T> n = front; n.hasNext(); n = n.next) {
            if (Objects.equals(key, n.data)) {
                n.delete();
                return;
            }
        }
    }

    protected void deleteAll(T key) {
        for (Node<T> n = front; n.hasNext(); n = n.next) {
            if (Objects.equals(key, n.data)) {
                n.delete();
            }
        }
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

    protected void delete(int index) {
        getNode(index).delete();
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

    protected ImmutableListIterator<T> immutableIterator() {
        Node<T> node = new Node<>();
        node.next = front;
        return new ImmutableListIterator<>(node);
    }

    protected MutableListIterator<T> mutableIterator() {
        Node<T> node = new Node<>();
        node.next = front;
        return new MutableListIterator<>(node);
    }

    protected boolean search(T key) {
        for (Node<T> n = front; n.hasNext(); n = n.next) {
            if (Objects.equals(key, n.data)) {
                return true;
            }
        }
        return false;
    }

    protected void sort(Comparator<T> c) {
        quickSort(c, front, back);
    }

    private void quickSort(Comparator<T> c, Node<T> start, Node<T> end) {
        if (start == end) return;
        Node<T> wall, n;
        n = wall = start;
        while (n != end) {
            if (c.compare(n.data, end.data) < 1) {
                n.swap(wall);
                wall = wall.next;
            }
            n = n.next;
        }
        n.swap(wall);
        if (start.next != end) {
            if (wall.hasPrev() && wall != start) quickSort(c, start, wall.prev);
            if (wall.hasNext() && wall != end) quickSort(c, wall.next, end);
        }
    }

    protected void iterate(Consumer<T> block) {
        Node<T> node = front;
        do {
            block.accept(node.data);
        } while ((node = node.next) != null);
    }

    protected void transform(UnaryOperator<T> operator) {
        Node<T> node = front;
        for (int i = 0; i < size(); i++) {
            node.data = operator.apply(node.data);
            node = node.next;
        }
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
