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
 * # insert(Node, Integer)
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

    protected void insert(Node<T> newNode, int index) {
        Node<T> node = front;
        for (int i = 0; i < index; i++) {
            if (node != null) {
                node = node.next;
            } else {
                throw new IndexOutOfBoundsException();
            }
            Node.insertNext(node, newNode);
        }
    }

    protected void pushFront(T obj) {

    }
    protected void pushBack(T obj) {

    }

    protected void delete(int index) {

    }
}
