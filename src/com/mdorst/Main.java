package com.mdorst;

import com.mdorst.container.list.List;
import com.mdorst.container.list.Queue;

public class Main {

    public static void main(String[] args) {
        TestLogger test = new TestLogger();
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
        Queue<Integer> unsorted = new Queue<>(queue);
        queue.sort(Integer::compareTo);
        Queue<Integer> sorted = new Queue<>(queue);
        for (int i = 1; i <= 10; i++) {
            test.assertEqual(i, queue.dequeue(), "Queue is not sorted");
        }
        test.assertEqual(queue.size(), 0, "Queue should be empty after all elements are dequeued");
        test.assertEqual(unsorted.toString(), "[5, 3, 8, 1, 7, 10, 4, 9, 6, 2]");
        List<String> list = new List<>();
        list.pushBack("Hello");
        list.pushBack("What's up");
        list.pushBack("Goodbye");
        list.pushBack("How do you do?");
        list.pushBack("Do I know you?");
        test.assertEqual(list.toString(), "[Hello, What's up, Goodbye, How do you do?, Do I know you?]");
        list.sort(String::compareTo);
        test.assertEqual(list.toString(), "[Do I know you?, Goodbye, Hello, How do you do?, What's up]");
        String query = "How do you do?";
        test.assertTrue(list.search(query), list + " should contain \"" + query + "\"");
        list.delete(query);
        test.assertFalse(list.search(query), list + " should not contain \"" + query + "\"");
        test.done();
    }
}
