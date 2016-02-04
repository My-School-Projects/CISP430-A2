package com.mdorst.container.list;

/**
 * Michael Dorst
 */

/**
 * List is a ListBase
 *
 * T : Generic
 *
 * Predicate : (Function(T, T) : Boolean)
 * Processor : (Function(T) : T)
 *
 * List
 * + insert(Integer)
 * + pushFront(T)
 * + pushBack(T)
 * + delete(Integer)
 * + popFront() : T
 * + popBack() : T
 * + sort(Predicate)
 * + iterate(Processor)
 * + search(T, Predicate) : Boolean
 * + constructor()
 * + constructor(ListBase)
 */

public class List<T> extends ListBase<T> {
    
}
