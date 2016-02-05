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
 * <<static>> + swapNext(Node)
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
        temp.prev = newNode;
        newNode.prev = node;
    }

    public static <T> void insertPrev(Node<T> node, Node<T> newNode) {
        if (node == null || newNode == null) {
            throw new NullPointerException();
        }
        Node<T> temp = node.prev;
        node.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        newNode.next = node;
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

    public static <T> void swapNext(Node<T> node) {
        if (node == null || node.next == null) {
            throw new NullPointerException();
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next.next.prev = node;
        node.next = node.next.next;
        node.prev.next.next = node;
        node.prev = node.prev.next;
    }
}
