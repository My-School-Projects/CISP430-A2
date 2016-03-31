package com.mdorst;

import com.mdorst.container.list.*;

public class Main {

    public static void main(String[] args) {
        TestRunner test = new TestRunner();
        test.verbose = false;
        {
            test.log("===================");
            test.log("LinkedList<Integer>");
            test.log("===================");
            LinkedList<Integer> list = new LinkedList<>();
            test.assertEqual(list.size(), 0, "size()");
            test.assertTrue(list.isEmpty(), "isEmpty()");
            test.assertFalse(list.contains(5), "contains(5)");
            test.assertFalse(list.iterator().hasNext(), "iterator().hasNext()");
            test.log("add(5)");
            list.add(5);
            test.assertEqual(list.size(), 1, "size()");
            test.assertFalse(list.isEmpty(), "isEmpty()");
            test.assertTrue(list.contains(5), "contains(5)");
            test.assertFalse(list.contains(2), "contains(2)");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext()");
            test.log("=================");
            test.log("Iterator<Integer>");
            test.log("=================");
            Iterator<Integer> iter = list.iterator();
            test.assertTrue(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), 5, "next()");
            test.assertEqual(iter.next(), null, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.log("add(2)");
            list.add(2);
            test.assertEqual(list.size(), 2, "size()");
            test.assertTrue(list.contains(5), "contains(5)");
            test.assertTrue(list.contains(2), "contains(2)");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext()");
            test.log("Reset iterator");
            iter = list.iterator();
            test.assertEqual(iter.next(), 5, "next()");
            test.assertEqual(iter.next(), 2, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
        }
        {
            test.log("==================");
            test.log("SortedList<Double>");
            test.log("==================");
            SortedList<Double> list = new SortedList<>();
            test.assertEqual(list.size(), 0, "size()");
            test.assertTrue(list.isEmpty(), "isEmpty()");
            test.assertFalse(list.contains(5), "contains(5)");
            test.assertFalse(list.iterator().hasNext(), "iterator().hasNext()");
            test.log("add(5.0)");
            list.add(5.0);
            test.assertEqual(list.size(), 1, "size()");
            test.assertFalse(list.isEmpty(), "isEmpty()");
            test.assertTrue(list.contains(5.0), "contains(5)");
            test.assertFalse(list.contains(2.0), "contains(2)");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext()");
            test.log("================");
            test.log("Iterator<Double>");
            test.log("================");
            Iterator<Double> iter = list.iterator();
            test.assertEqual(iter.next(), 5.0, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
            test.log("add(2.0)");
            test.log("Reset iterator");
            list.add(2.0);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "next()");
            test.assertEqual(iter.next(), 5.0, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
            test.log("add(10.0)");
            test.log("Reset iterator");
            list.add(10.0);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "next()");
            test.assertEqual(iter.next(), 5.0, "next()");
            test.assertEqual(iter.next(), 10.0, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
            test.log("add(4.9)");
            test.log("Reset iterator");
            list.add(4.9);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "next()");
            test.assertEqual(iter.next(), 4.9, "next()");
            test.assertEqual(iter.next(), 5.0, "next()");
            test.assertEqual(iter.next(), 10.0, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
            test.log("add(1.5)");
            test.log("Reset iterator");
            list.add(1.5);
            iter = list.iterator();
            test.assertEqual(iter.next(), 1.5, "next()");
            test.assertEqual(iter.next(), 2.0, "next()");
            test.assertEqual(iter.next(), 4.9, "next()");
            test.assertEqual(iter.next(), 5.0, "next()");
            test.assertEqual(iter.next(), 10.0, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
            test.assertEqual(list.size(), 5, "size()");
            test.assertTrue(list.remove(5.0), "remove(5.0)");
            test.assertEqual(list.size(), 4, "size()");
            test.assertFalse(list.remove(5.0), "remove(5.0)");
            test.assertEqual(list.size(), 4, "size()");
            test.assertTrue(list.remove(1.5), "remove(1.5)");
            test.assertEqual(list.size(), 3, "size()");
            test.log("Reset iterator");
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "next()");
            test.assertEqual(iter.next(), 4.9, "next()");
            test.assertEqual(iter.next(), 10.0, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
            test.assertTrue(list.remove(4.9), "remove(4.9)");
            test.assertTrue(list.remove(10.0), "remove(10.0)");
            test.assertTrue(list.remove(2.0), "remove(2.0)");
            test.assertEqual(list.size(), 0, "size()");
            test.assertFalse(list.iterator().hasNext(), "iterator().hasNext()");
        }
        {
            class MagicBox {
                private Object o;
                MagicBox(Object o) {
                    this.o = o;
                }
                public Object open() {
                    return o;
                }
            }
            test.log("===============");
            test.log("Stack<MagicBox>");
            test.log("===============");
            Stack<MagicBox> stack;
            {
                Stack<MagicBox> c = new Stack<>();
                stack = (Stack<MagicBox>) c;
            }
            test.assertEqual(stack.size(), 0, "size()");
            test.assertTrue(stack.isEmpty(), "isEmpty()");
            test.assertFalse(stack.contains(5), "contains(5)");
            test.assertFalse(stack.iterator().hasNext(), "iterator().hasNext()");
            test.log("push(new MagicBox(5))");
            stack.push(new MagicBox(5));
            test.assertEqual(stack.top().open(), 5, "top().open()");
            test.log("push(new MagicBox(\"hello\"))");
            stack.push(new MagicBox("hello"));
            test.assertEqual(stack.top().open(), "hello", "top().open()");
            test.log("push(new MagicBox(new MagicBox(3.14))");
            stack.push(new MagicBox(new MagicBox(3.14)));
            test.assertEqual(((MagicBox)stack.top().open()).open(), 3.14, "top().open().open()");
            test.assertEqual(stack.size(), 3, "size()");
            test.assertEqual(((MagicBox)stack.pop().open()).open(), 3.14, "pop().open().open()");
            test.assertEqual(stack.size(), 2, "size()");
            test.assertEqual(stack.pop().open(), "hello", "pop().open()");
            test.assertEqual(stack.pop().open(), 5, "pop().open()");
            test.assertEqual(stack.size(), 0, "size()");
            test.assertEqual(stack.pop(), null, "pop()");
            test.assertEqual(stack.pop(), null, "pop()");
            test.assertEqual(stack.size(), 0, "size()");
            test.log("push(new MagicBox(23.5f))");
            stack.push(new MagicBox(23.5f));
            test.assertEqual(stack.pop().open(), 23.5f, "pop().open()");
            test.assertEqual(stack.pop(), null, "pop()");
        }
        {
            test.log("=============");
            test.log("Queue<String>");
            test.log("=============");
            Queue<String> queue;
            {
                Queue<String> c = new Queue<>();
                queue = (Queue<String>)c;
            }
            test.assertEqual(queue.size(), 0, "size()");
            test.assertTrue(queue.isEmpty(), "isEmpty()");
            test.assertFalse(queue.contains(5), "contains(5)");
            test.assertFalse(queue.iterator().hasNext(), "iterator().hasNext()");
            test.log("enqueue(\"hello\")");
            queue.enqueue("hello");
            test.assertEqual(queue.front(), "hello", "front()");
            test.log("enqueue(\"goodbye\")");
            queue.enqueue("goodbye");
            test.assertEqual(queue.front(), "hello", "front()");
            test.log("enqueue(\"what's up?\")");
            queue.enqueue("what's up?");
            test.log("================");
            test.log("Iterator<String>");
            test.log("================");
            Iterator<String> iter = queue.iterator();
            test.assertTrue(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), "hello", "next()");
            test.assertTrue(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), "goodbye", "next()");
            test.assertTrue(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), "what's up?", "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
            test.assertEqual(queue.size(), 3, "size()");
            test.assertEqual(queue.dequeue(), "hello", "dequeue()");
            test.assertEqual(queue.size(), 2, "size()");
            test.assertEqual(queue.dequeue(), "goodbye", "dequeue()");
            test.assertEqual(queue.dequeue(), "what's up?", "dequeue()");
            test.assertEqual(queue.size(), 0, "size()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
            test.log("enqueue(\"just in case...\")");
            queue.enqueue("just in case...");
            test.assertEqual(queue.front(), "just in case...", "front()");
            test.assertEqual(queue.dequeue(), "just in case...", "dequeue()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
            test.assertEqual(queue.size(), 0, "size()");
        }
        {
            test.log("====================");
            test.log("PriorityQueue<Float>");
            test.log("====================");
            PriorityQueue<Float> queue = new PriorityQueue<>();
            test.assertEqual(queue.size(), 0, "size()");
            test.assertTrue(queue.isEmpty(), "isEmpty()");
            test.assertFalse(queue.contains(5), "contains(5)");
            test.assertFalse(queue.iterator().hasNext(), "iterator().hasNext()");
            test.log("enqueue(3f)");
            queue.enqueue(3f);
            test.assertEqual(queue.front(), 3f, "front()");
            test.log("enqueue(5f)");
            queue.enqueue(5f);
            test.assertEqual(queue.front(), 3f, "front()");
            test.log("enqueue(2f)");
            queue.enqueue(2f);
            test.assertEqual(queue.front(), 2f, "front()");
            test.log("enqueue(4f)");
            queue.enqueue(4f);
            test.assertEqual(queue.front(), 2f, "front()");
            test.log("enqueue(1f)");
            queue.enqueue(1f);
            test.assertEqual(queue.front(), 1f, "front()");
            test.assertEqual(queue.size(), 5, "size()");
            test.assertEqual(queue.dequeue(), 1f, "dequeue()");
            test.assertEqual(queue.size(), 4, "size()");
            test.assertEqual(queue.dequeue(), 2f, "dequeue()");
            test.assertEqual(queue.dequeue(), 3f, "dequeue()");
            test.assertEqual(queue.front(), 4f, "front()");
            test.assertEqual(queue.dequeue(), 4f, "dequeue()");
            test.assertEqual(queue.dequeue(), 5f, "dequeue()");
            test.assertEqual(queue.size(), 0, "size()");
            test.assertEqual(queue.front(), null, "front()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
            test.assertEqual(queue.size(), 0, "size()");
        }
        test.done();
    }
}
