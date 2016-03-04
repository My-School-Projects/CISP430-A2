package com.mdorst.container.list;

/*
 * Stack is a BasicList
 *
 * T : Generic
 *
 * Stack
 * + push(T)
 * + pop() : T
 * + top() : T
 */

/**
 * This class extends BasicList, and provides methods to support
 * a LIFO stack pattern.
 *
 * @param <T> the type of the elements held in this collection
 */
public class Stack<T> extends BasicList<T> {
    /**
     * Adds an element to the top of the stack
     *
     * @param obj the element to be added
     */
    public void push(T obj) {
        super.pushFront(obj);
    }

    /**
     * Removes an element from the top of the stack, returning it to the caller
     *
     * @return the removed element
     */
    public T pop() {
        return super.popFront();
    }

    /**
     * Peeks at the element at the top of the stack
     *
     * @return the element at the top of the stack
     */
    public T top() {
        return front.data;
    }
}
