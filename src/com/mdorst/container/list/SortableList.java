package com.mdorst.container.list;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/* SortableList
 * + search(T) : Boolean
 * + sort(Predicate)
 * + iterator() : ListIterator
 * + iterate(Function)
 */

/**
 * This class extends ListBase, and provides all of the methods
 * common to the List and Queue classes.
 *
 * @param <T> the type of the elements held in this collection
 */
class SortableList<T> extends ListBase<T> {
    /**
     * Searches the collection for an element matching key
     *
     * @param key the element to find
     * @return <tt>true</tt> if an element matching <tt>key</tt>
     * exists withing the collection, <tt>false</tt> otherwise
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

    public ListIterator<T> iterator() {
        Node<T> node = new Node<>();
        node.next = front;
        return new ListIterator<>(node);
    }

    /**
     * Iterates over the list, calling <tt>block</tt> on each element
     *
     * @param block the function to be called on each element
     */
    public void iterate(Consumer<T> block) {
        Node<T> node = front;
        do {
            block.accept(node.data);
        } while ((node = node.next) != null);
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
}
