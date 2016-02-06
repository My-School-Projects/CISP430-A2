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
 * + constructor()
 * + constructor(T)
 *
 * <<static>> + insertNext(Node, Node)
 * <<static>> + insertPrev(Node, Node)
 * <<static>> + delete(Node)
 * <<static>> + swap(Node, Node)
 */

class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node() {}
    public Node(T obj) {
        data = obj;
    }

    public static <T> void insertNext(Node<T> node, Node<T> newNode) {
        if (node == null || newNode == null) {
            throw new NullPointerException();
        }
        Node<T> temp = node.next;
        node.next = newNode;
        newNode.next = temp;
        newNode.prev = node;
        if (temp != null) {
            temp.prev = newNode;
        }
    }

    public static <T> void insertPrev(Node<T> node, Node<T> newNode) {
        if (node == null || newNode == null) {
            throw new NullPointerException();
        }
        Node<T> temp = node.prev;
        node.prev = newNode;
        newNode.prev = temp;
        newNode.next = node;
        if (temp != null) {
            temp.next = newNode;
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

    public static <T> void swap(Node<T> n, Node<T> o) {
        n.next.prev = o;
        n.prev.next = o;
        o.next.prev = n;
        o.prev.next = n;
        Node<T> temp = n.next;
        n.next = o.next;
        o.next = temp;
        temp = n.prev;
        n.prev = o.prev;
        o.prev = temp;
    }
}
