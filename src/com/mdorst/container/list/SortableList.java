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
 * @param <T> the type of the elements held in this collection
 */
class SortableList<T> extends BasicList<T> implements Iterable<T> {
    /**
     * Searches the collection for an element matching key
     *
     * @param key the element to find
     * @return {@code true} if an element matching {@code key}
     * exists withing the collection, {@code false} otherwise
     */
    public boolean search(T key) {
        for (Node<T> n = front; n.hasNext(); n = n.next) {
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
    public void sort(Comparator<T> c) {
        quickSort(c, front, back);
    }

    public Iterator<T> iterator() {
        Node<T> node = new Node<>();
        node.next = front;
        return new Iterator<>(node);
    }

    private void quickSort(Comparator<T> c, Node<T> start, Node<T> end) {
        if (start == end) return;
        Node<T> wall, n;
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

    public SortableList(BasicList<T> other) {
        super(other);
    }

    public SortableList() {}
}
