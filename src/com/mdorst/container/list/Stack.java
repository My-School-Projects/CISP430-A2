package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * Stack is a ListBase
 *
 * T : Generic
 *
 * Stack
 * + push(T)
 * + pop() : T
 * + top() : T
 * + constructor()
 * + constructor(ListBase)
 */

public class Stack<T> extends ListBase<T> {
    public void push(T obj) {
        super.pushFront(obj);
    }
    public T pop() {
        return super.popFront();
    }
    public T top() {
        return front.data;
    }
}
