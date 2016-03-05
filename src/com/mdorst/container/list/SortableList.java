package com.mdorst.container.list;

import java.util.Comparator;
import java.util.Objects;

/*
 * SortableList
 *
 * Comparator : (Function(T, T) : Boolean)
 *
 * + search(T) : Boolean
 * + sort(Comparator)
 * + iterator() : Iterator
 */

/**
 * This class extends BasicList, and provides all of the methods
 * common to the List and Queue classes.
 *
 * @param <E> the type of the elements held in this collection
 */
class SortableList<E extends Comparable<? super E>> extends BasicList<E> implements Iterable<E> {
    /**
     * Searches the collection for an element matching key
     *
     * @param key the element to find
     * @return {@code true} if an element matching {@code key}
     * exists withing the collection, {@code false} otherwise
     */
    public boolean search(E key) {
        for (Node<E> n = front; n.hasNext(); n = n.next) {
            if (Objects.equals(key, n.data)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts the list using QuickSort
     *
     * @param c the comparator used to decide sorting order
     */
    public void sort(Comparator<E> c) {
        quickSort(c, front, back);
    }

    public Iterator<E> iterator() {
        Node<E> node = new Node<>();
        node.next = front;
        return new Iterator<>(node);
    }

    private void quickSort(Comparator<E> c, Node<E> start, Node<E> end) {
        if (start == end) return;
        Node<E> wall, n;
        n = wall = start;
        while (n != end) {
            if (c.compare(n.data, end.data) < 1) {
                n.swap(wall);
                wall = wall.next;
            }
            n = n.next;
        }
        n.swap(wall);
        if (start.next != end) {
            if (wall.hasPrev() && wall != start) quickSort(c, start, wall.prev);
            if (wall.hasNext() && wall != end) quickSort(c, wall.next, end);
        }
    }

    public SortableList(BasicList<E> other) {
        super(other);
    }

    public SortableList() {}
}
