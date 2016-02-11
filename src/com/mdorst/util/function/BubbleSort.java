package com.mdorst.util.function;

import com.mdorst.container.Iterator;

import java.util.Comparator;

/**
 * Michael Dorst
 */
public class BubbleSort<T> implements Sort<T> {

    @Override
    public void call(Comparator<T> comp, Iterator<T> it) {
        Iterator<T> copy = it;
        while (it.hasNext()) {
            if (comp.compare(it.next(), it.next()) == 1) {
                (copy = it.copy()).prev();
                
            }
        }
    }
}
