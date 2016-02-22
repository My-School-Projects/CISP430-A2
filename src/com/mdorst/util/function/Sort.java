package com.mdorst.util.function;

import com.mdorst.container.Iterator;

import java.util.Comparator;

/**
 * Michael Dorst
 */
public interface Sort<T> {
    public void call(Comparator<T> pred, Iterator<T> it);
}
