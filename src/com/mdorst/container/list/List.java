package com.mdorst.container.list;

/**
 * Michael Dorst
 */

import java.util.Comparator;
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
 * + pushFront(T)
 * + pushBack(T)
 * + delete(Integer)
 * + popFront() : T
 * + popBack() : T
 * + sort(Predicate)
 * + immutableIterator() : ImmutableListIterator
 * + mutableIterator() : MutableListIterator
 * + iterate(Block)
 * + transform(UnaryOperator)
 * + search(T, Predicate) : Boolean
 * + constructor()
 * + constructor(ListBase)
 */

public class List<T> extends ListBase<T> {
    @Override
    public void insert(Node<T> newNode, int index) {
        super.insert(newNode, index);
    }

    @Override
    public T get(int index) {
        return super.get(index);
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
    public void delete(int index) {
        super.delete(index);
    }

    @Override
    public void delete(T key) {
        super.delete(key);
    }

    @Override
    public void deleteAll(T key) {
        super.deleteAll(key);
    }

    @Override
    public T popFront() {
        return super.popFront();
    }

    @Override
    public T popBack() {
        return super.popBack();
    }

    @Override
    public ImmutableListIterator<T> immutableIterator() {
        return super.immutableIterator();
    }

    @Override
    public MutableListIterator<T> mutableIterator() {
        return super.mutableIterator();
    }

    @Override
    public void iterate(Consumer<T> block) {
        super.iterate(block);
    }

    @Override
    public void transform(UnaryOperator<T> operator) {
        super.transform(operator);
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
    public int size() {
        return super.size();
    }
}
