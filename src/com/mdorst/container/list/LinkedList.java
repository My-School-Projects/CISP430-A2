package com.mdorst.container.list;

import java.util.Objects;

public class LinkedList<E> implements Iterable<E> {
    protected Node<E> head;
    protected int size;

    public LinkedList() {
        head = new Node<>();
        head.next = head.prev = head;
    }

    public LinkedList(LinkedList<E> c) {
        this();
        for (Node<E> n = c.head.next; n != head; n = n.next) {
            add(n.data);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * WARNING: This method CANNOT guarantee that the next call to {@code add()} will
     * not fail! While there may be memory available at the time of this call, there is no
     * guarantee that there will still be memory available at the time of any subsequent
     * call to {@code add()}.
     *
     * This method is NOT recommended for use. The appropriate way to handle lack of memory
     * is to catch {@code OutOfMemoryError}s upon calls to {@code add()}.
     * eg.
     * <code>
     *     try {
     *         linkedList.add(someObject);
     *     } catch (OutOfMemoryError e) {
     *         // handle error
     *     }
     * </code>
     *
     * @return false unless there is no more memory available at the time of this call.
     */
    public boolean isFull() {
        try {
            new Node<E>();
        } catch (OutOfMemoryError e) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        for (Node<E> n = head.next; n != head; n = n.next) {
            if (Objects.equals(o, n.data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>(head);
    }

    /**
     * Appends the specified element to the end of the list
     *
     * @param e the element to be appended
     * @return {@code true}
     */
    public boolean add(E e) {
        Node<E> n = new Node<>(e);
        head.prev.next = n;
        n.prev = head.prev;
        head.prev = n;
        n.next = head;
        size++;
        return true;
    }

    /**
     * Removes a single instance of the specified element from the list
     * if it is present.
     *
     * @param o the element to be removed, if present
     * @return {@code true} if an element was removed as a result of this call
     */
    public boolean remove(Object o) {
        for (Node<E> n = head.next; n != head; n = n.next) {
            /**
             * If o == null, checks for null elements.
             * Otherwise, checks for o.equals(element)
             */
            if (o == null ? n.data == null : o.equals(n.data)) {
                n.delete();
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from this collection.
     * The collection will be empty after this method returns.
     */
    public void clear() {
        head.next = head;
        head.prev = head;
    }

    @Override
    public String toString() {
        String s = "[";
        for (Node<E> n = head.next; n != head; n = n.next) {
            if (!Objects.equals(s, "[")) s += ", ";
            s += n.data.toString();
        }
        return s + "]";
    }
}
