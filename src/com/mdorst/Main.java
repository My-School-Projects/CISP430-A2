package com.mdorst;

import com.mdorst.container.list.ImmutableListIterator;
import com.mdorst.container.list.List;
import com.mdorst.container.list.MutableListIterator;

public class Main {

    public static void main(String[] args) {
        List<String> list = new List<>();
        list.pushBack("hello");
        list.pushBack("what's up?");
        list.pushBack("goodbye");
        list.transform((data) -> data += " MODIFIED!");
        ImmutableListIterator<String> it = list.immutableIterator();
        /*while (it.hasNext()) {
            System.out.println(it.next());
        }*/
        MutableListIterator<String> mit = list.mutableIterator();
        while (mit.hasNext()) {
            mit.next();
            mit.set(mit.get() + " AGAIN!!");
        }
        //list.iterate(System.out::println);
        list.sort(String::compareTo);
        list.iterate(System.out::println);
    }
}
