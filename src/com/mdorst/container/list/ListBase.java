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
 * # size : Integer
 *
 * + size() : Integer
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
    protected int size;

    protected void insert(Node<T> newNode, int index) {
        Node<T> node = front;
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node.insertNext(node, newNode);
        size++;
    }

    protected void pushFront(T obj) {
        insert(new Node<>(obj), 0);
    }
    protected void pushBack(T obj) {
        insert(new Node<>(obj), size()-1);
    }

    protected void delete(int index) {

    }

    public int size() {
        return size;
    }

    public ListBase() {
        front = new Node<>();
        size = 0;
    }
}
