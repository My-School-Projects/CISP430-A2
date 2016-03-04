package com.mdorst.container.list;

/*
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

/**
 * This class provides the facility to implement a linked list.
 * <p>
 * It holds a generic data member, as well as two references to other {@code Node}'s,
 * which serve as forward and backward references to the adjacent links in the list.
 *
 * @param <T> the type of the elements held in the linked list
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

    /**
     * Inserts a new {@code Node} between this node and the node
     * referenced by {@code next}
     *
     * @param node the node to be inserted
     */
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

    /**
     * Inserts a new {@code Node} between this node and the node
     * referenced by {@code prev}
     *
     * @param node the node to be inserted
     */
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

    /**
     * Deletes this node, reorienting the {@code next} and {@code prev} nodes
     * to reference each other, skipping over this one
     */
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
