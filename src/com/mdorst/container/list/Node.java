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
 * + constructor()
 * + constructor(T)
 *
 * <<static>> - swap_adjacent(Node, Node)
 * <<static>> - swap_non_adjacent(Node, Node)
 * <<static>> + insertNext(Node, Node)
 * <<static>> + insertPrev(Node, Node)
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
        if (this.next == node) {
            swap_adjacent(this, node);
        } else if (this.prev == node) {
            swap_adjacent(node, this);
        } else {
            swap_non_adjacent(this, node);
        }
    }

    private static <T> void swap_adjacent(Node<T> n, Node<T> o) {
        n.next = o.next;
        if (n.next != null) o.next.prev = n;
        o.next = n;
        o.prev = n.prev;
        if (n.prev != null) n.prev.next = o;
        n.prev = o;
    }

    private static <T> void swap_non_adjacent(Node<T> n, Node<T> o) {
        if (n.hasNext()) n.next.prev = o;
        if (n.hasPrev()) n.prev.next = o;
        if (o.hasNext()) o.next.prev = n;
        if (o.hasPrev()) o.prev.next = n;
        Node<T> temp = n.next;
        n.next = o.next;
        o.next = temp;
        temp = n.prev;
        n.prev = o.prev;
        o.prev = temp;
    }

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
}
