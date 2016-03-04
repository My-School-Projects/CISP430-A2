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
 * + pushFront(T)
 * + pushBack(T)
 * + delete(Integer)
 * + popFront() : T
 * + popBack() : T
 * + sort(Predicate)
 * + iterator() : ListIterator
 * + mutableIterator() : MutableListIterator
 * + iterate(Block)
 * + transform(UnaryOperator)
 * + search(T, Predicate) : Boolean
 * + constructor()
 * + constructor(ListBase)
 */

public class List<T> extends ListBase<T> {
    public void insert(T obj, int index) {
        getNode(index).insertNext(new Node<T>(obj));
        size++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public void delete(int index) {
        getNode(index).delete();
    }

    public void delete(T key) {
        for (Node<T> n = front; n.hasNext(); n = n.next) {
            if (Objects.equals(key, n.data)) {
                n.delete();
                return;
            }
        }
    }

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

    @Override
    public ListIterator<T> iterator() {
        return super.iterator();
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
