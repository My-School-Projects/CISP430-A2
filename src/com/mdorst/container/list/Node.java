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
 */

class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;
}
