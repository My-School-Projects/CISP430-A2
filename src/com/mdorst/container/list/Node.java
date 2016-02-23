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
 * <<static>> + delete(Node)
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

    public static <T> void delete(Node<T> node) {
        if (node == null) {
            throw new NullPointerException();
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
}
