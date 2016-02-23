package com.mdorst;

import com.mdorst.container.list.ImmutableListIterator;
import com.mdorst.container.list.List;
import com.mdorst.container.list.MutableListIterator;

public class Main {

    public static void main(String[] args) {
        List<String> list = new List<>();
        list.pushBack("Hello");
        list.pushBack("What's up");
        list.pushBack("Goodbye");
        list.pushBack("How do you do?");
        list.pushBack("Do I know you?");
        list.transform((data) -> data += " MODIFIED!");
        ImmutableListIterator<String> it = list.immutableIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        MutableListIterator<String> mit = list.mutableIterator();
        while (mit.hasNext()) {
            mit.next();
            mit.set(mit.get() + " AGAIN!!");
        }
        list.iterate(System.out::println);
        System.out.println();
        list.sort(String::compareTo);
        list.iterate(System.out::println);
        System.out.println(list.search("Hello MODIFIED! AGAIN!!"));
        list.delete("Hello MODIFIED! AGAIN!!");
        System.out.println(list.search("Hello MODIFIED! AGAIN!!"));
    }
}
