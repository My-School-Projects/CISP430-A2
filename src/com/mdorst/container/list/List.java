package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * List is a ListBase
 *
 * T : Generic
 *
 * Predicate : (Function(T, T) : Boolean)
 * Processor : (Function(T) : T)
 *
 * List
 * + insert(Node, Integer)
 * + pushFront(T)
 * + pushBack(T)
 * + delete(Integer)
 * + popFront() : T
 * + popBack() : T
 * + sort(Predicate)
 * + iterate(Processor)
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
    public T popFront() {
        return super.popFront();
    }

    @Override
    public T popBack() {
        return super.popBack();
    }

    @Override
    public int size() {
        return super.size();
    }
}
