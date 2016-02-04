package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * T : Generic
 *
 * Predicate : (Function(T, T) : Boolean)
 * Processor : (Function(T) : T)
 *
 * ListBase
 * # front : Node
 * # back : Node
 *
 * # insert(Integer)
 * # pushFront(T)
 * # pushBack(T)
 * # delete(Integer)
 * # popFront() : T
 * # popBack() : T
 * # sort(Predicate)
 * # iterate(Processor)
 * # search(T, Predicate) : Boolean
 * + constructor()
 * + constructor(ListBase)
 */

class ListBase<T> {
    protected Node<T> front;

    protected void insert(int index) {
        Node<T> n = front;
        for (int i = 0; i < index; i++) {
            if (n != null) {
                n = n.next;
            } else {
                throw new IndexOutOfBoundsException();
            }

        }
    }

    protected void pushFront(T obj) {

    }
    protected void pushBack(T obj) {

    }

    protected void delete(int index) {

    }
}
