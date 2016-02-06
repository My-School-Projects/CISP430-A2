package com.mdorst.container.list;

/**
 * Michael Dorst
 */

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
 * - size : Integer
 *
 * + size() : Integer
 * # insert(Node, Integer)
 * # pushFront(T)
 * # pushBack(T)
 * # delete(Integer)
 * # popFront() : T
 * # popBack() : T
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
    protected Node<T> front;
    protected int size;

    public int size() {
        return size;
    }

    protected void insert(Node<T> newNode, int index) {
        Node.insertNext(getNode(index), newNode);
        size++;
    }

    protected void pushFront(T obj) {
        insert(new Node<>(obj), 0);
    }
    protected void pushBack(T obj) {
        if (size() == 0) {
            front = new Node<>(obj);
            size++;
        } else {
            insert(new Node<>(obj), size()-1);
        }
    }

    protected void delete(int index) {
        Node.delete(getNode(index));
    }

    protected T popFront() {
        Node<T> node = getNode(0);
        Node.delete(node);
        return node.data;
    }

    protected T popBack() {
        Node<T> node = getNode(size()-1);
        Node.delete(node);
        return node.data;
    }

    protected ImmutableListIterator<T> immutableIterator() {
        return new ImmutableListIterator<>(front);
    }

    protected MutableListIterator<T> mutableIterator() {
        return new MutableListIterator<>(front);
    }

    protected void iterate(Consumer<T> block) {
        Node<T> node = front;
        for (int i = 0; i < size(); i++) {
            block.accept(node.data);
            node = node.next;
        }
    }

    protected void transform(UnaryOperator<T> operator) {
        Node<T> node = front;
        for (int i = 0; i < size(); i++) {
            node.data = operator.apply(node.data);
            node = node.next;
        }
    }

    private Node<T> getNode(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = front;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
