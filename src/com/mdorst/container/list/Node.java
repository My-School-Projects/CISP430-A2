package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * T : Generic
 *
 * Node
 * + data : T
 * + next : Node
 * + prev : Node
 * + swap(Node)
 * + hasNext() : Boolean
 * + hasPrev() : Boolean
 * + insertNext(Node)
 * + constructor()
 * + constructor(T)
 * + delete()
 */

class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public boolean hasNext() {
        return next != null;
    }
    public boolean hasPrev() {
        return prev != null;
    }

    public void swap(Node<T> node) {
        T temp = this.data;
        this.data = node.data;
        node.data = temp;
    }

    public Node() {}
    public Node(T obj) {
        data = obj;
    }

    public void insertNext(Node<T> node) {
        if (node == null) {
            throw new NullPointerException();
        }
        Node<T> temp = this.next;
        this.next = node;
        node.next = temp;
        node.prev = this;
        if (temp != null) {
            temp.prev = node;
        }
    }
    
    public void insertPrev(Node<T> node) {
        if (node == null) {
            throw new NullPointerException();
        }
        Node<T> temp = this.prev;
        this.prev = node;
        node.prev = temp;
        node.next = this;
        if (temp != null) {
            temp.next = node;
        }
    }
    
    public void delete() {
        if (hasPrev()) {
            prev.next = next;
        }
        if (hasNext()) {
            next.prev = prev;
        }
        next = prev = null;
    }
}
