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
 *
 * <<static>> + insertNext(Node, Node)
 * <<static>> + swapNext(Node)
 */

class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public static <T> void insertNext(Node<T> loc, Node<T> obj) {
        if (loc == null || obj == null) {
            throw new NullPointerException();
        }
        Node<T> temp = loc.next;
        loc.next = obj;
        temp.prev = obj;
        obj.prev = loc;
        obj.next = temp;
    }

    public static <T> void swapNext(Node<T> node) {
        if (node == null || node.next == null) {
            throw new NullPointerException();
        }
        node.prev.next = node.next;
        node.next.next.prev = node;
        // TODO: finish
    }
}
