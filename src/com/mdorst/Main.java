package com.mdorst;

import com.mdorst.container.list.ImmutableListIterator;
import com.mdorst.container.list.List;
import com.mdorst.container.list.MutableListIterator;
import com.mdorst.container.list.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(8);
        queue.enqueue(1);
        queue.enqueue(7);
        queue.enqueue(10);
        queue.enqueue(4);
        queue.enqueue(9);
        queue.enqueue(6);
        queue.enqueue(2);
        queue.sort(Integer::compareTo);
        queue.iterate(i -> System.out.print(i + " "));
        System.out.println();
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
        String query = "Hello MODIFIED! AGAIN!!";
        System.out.println();
        if (list.search(query)) {
            System.out.println("Found \"" + query + "\"");
        } else {
            System.out.println("Did not find \"" + query + "\"");
        }
        list.delete(query);
        if (list.search(query)) {
            System.out.println("Found \"" + query + "\"");
        } else {
            System.out.println("Did not find \"" + query + "\"");
        }
    }
}
