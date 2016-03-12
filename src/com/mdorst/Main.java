package com.mdorst;

import com.mdorst.container.list.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        TestRunner test = new TestRunner();
        test.verbose = true;
        {
            test.log("===================");
            test.log("LinkedList<Integer>");
            test.log("===================");
            Collection<Integer> list = new LinkedList<>();
            test.assertEqual(list.size(), 0, "size()");
            test.assertTrue(list.isEmpty(), "isEmpty()");
            test.assertFalse(list.contains(5), "contains(5)");
            test.assertTrue(list.containsAll(list), "containsAll(self)");
            test.assertFalse(list.iterator().hasNext(), "iterator().hasNext()");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[]{}), "(toArray() == new Object[]{}");
            test.log("add(5)");
            list.add(5);
            test.assertEqual(list.size(), 1, "size()");
            test.assertFalse(list.isEmpty(), "isEmpty()");
            test.assertTrue(list.contains(5), "contains(5)");
            test.assertFalse(list.contains(2), "contains(2)");
            test.assertTrue(list.containsAll(list), "containsAll(self)");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext()");
            test.log("=================");
            test.log("Iterator<Integer>");
            test.log("=================");
            Iterator<Integer> iter = list.iterator();
            test.assertTrue(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), 5, "next()");
            test.assertEqual(iter.next(), null, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(list.toArray().length, 1, "toArray().length");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[]{5}), "(toArray() == new Object[]{5})");
            test.log("add(2)");
            list.add(2);
            test.assertEqual(list.size(), 2, "size()");
            test.assertTrue(list.contains(5), "contains(5)");
            test.assertTrue(list.contains(2), "contains(2)");
            test.assertTrue(list.containsAll(list), "containsAll(self)");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext()");
            test.log("Reset iterator");
            iter = list.iterator();
            test.assertEqual(iter.next(), 5, "next()");
            test.assertEqual(iter.next(), 2, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(list.toArray().length, 2, "toArray()");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[]{5, 2}), "(toArray() == new Object[]{5, 2})");
            test.log("addAll(11, 3, 115)");
            {
                LinkedList<Integer> list2 = new LinkedList<>();
                list2.add(11);
                list2.add(3);
                list2.add(115);
                list.addAll(list2);
            }

            test.assertTrue(list.contains(11), "contains(11)");
            test.assertTrue(list.contains(3), "contains(3)");
            test.assertTrue(list.contains(115), "contains(115)");
            test.log("Reset iterator");
            iter = list.iterator();
            test.assertEqual(iter.next(), 5, "next()");
            test.assertEqual(iter.next(), 2, "next()");
            test.assertEqual(iter.next(), 11, "next()");
            test.assertEqual(iter.next(), 3, "next()");
            test.assertTrue(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), 115, "next()");
            test.assertFalse(iter.hasNext(), "hasNext()");
            test.assertEqual(iter.next(), null, "next()");
        }
        {
            test.log("==================");
            test.log("SortedList<Double>");
            test.log("==================");
            Collection<Double> list = new SortedList<>();
            test.assertEqual(list.size(), 0, "size()");
            test.assertTrue(list.isEmpty(), "isEmpty()");
            test.assertFalse(list.contains(5), "contains(5)");
            test.assertTrue(list.containsAll(list), "containsAll(self)");
            test.assertFalse(list.iterator().hasNext(), "iterator().hasNext()");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {}), "toArray()");
            test.log("add(5.0)");
            list.add(5.0);
            test.assertEqual(list.size(), 1, "size()");
            test.assertFalse(list.isEmpty(), "isEmpty()");
            test.assertTrue(list.contains(5.0), "contains(5)");
            test.assertFalse(list.contains(2.0), "contains(2)");
            test.assertTrue(list.containsAll(list), "containsAll(self");
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
                Collection<MagicBox> c = new Stack<>();
                stack = (Stack<MagicBox>) c;
            }
            test.assertEqual(stack.size(), 0, "size()");
            test.assertTrue(stack.isEmpty(), "isEmpty()");
            test.assertFalse(stack.contains(5), "contains(5)");
            test.assertTrue(stack.containsAll(stack), "containsAll(self)");
            test.assertFalse(stack.iterator().hasNext(), "iterator().hasNext()");
            test.assertTrue(Arrays.deepEquals(stack.toArray(), new Object[] {}), "toArray()");
            test.log("push(new MagicBox(5))");
            stack.push(new MagicBox(5));
            test.assertEqual(stack.top().open(), 5, "top().open()");
            test.log("push(new MagicBox(\"hello\"))");
            stack.push(new MagicBox("hello"));
            test.assertEqual(stack.top().open(), "hello", "top().open()");
            test.log("push(new MagicBox(new MagicBox(3.14))");
            stack.push(new MagicBox(new MagicBox(3.14)));
            test.assertEqual(((MagicBox)stack.top().open()).open(), 3.14, "top().open().open()");
            test.assertEqual(((MagicBox)stack.pop().open()).open(), 3.14, "pop().open().open()");
            test.assertEqual(stack.pop().open(), "hello", "pop().open()");
            test.assertEqual(stack.pop().open(), 5, "pop().open()");
            test.assertEqual(stack.pop(), null, "pop()");
            test.assertEqual(stack.pop(), null, "pop()");
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
                Collection<String> c = new Queue<>();
                queue = (Queue<String>)c;
            }
            test.assertEqual(queue.size(), 0, "size()");
            test.assertTrue(queue.isEmpty(), "isEmpty()");
            test.assertFalse(queue.contains(5), "contains(5)");
            test.assertTrue(queue.containsAll(queue), "containsAll(self)");
            test.assertFalse(queue.iterator().hasNext(), "iterator().hasNext()");
            test.assertTrue(Arrays.deepEquals(queue.toArray(), new Object[] {}), "toArray()");
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
            test.assertEqual(queue.dequeue(), "hello", "dequeue()");
            test.assertEqual(queue.dequeue(), "goodbye", "dequeue()");
            test.assertEqual(queue.dequeue(), "what's up?", "dequeue()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
            test.log("enqueue(\"just in case...\")");
            queue.enqueue("just in case...");
            test.assertEqual(queue.front(), "just in case...", "front()");
            test.assertEqual(queue.dequeue(), "just in case...", "dequeue()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
        }
        {
            test.log("====================");
            test.log("PriorityQueue<Float>");
            test.log("====================");
            PriorityQueue<Float> queue;
            {
                Collection<Float> c = new PriorityQueue<>();
                queue = (PriorityQueue<Float>)c;
            }
            test.assertEqual(queue.size(), 0, "size()");
            test.assertTrue(queue.isEmpty(), "isEmpty()");
            test.assertFalse(queue.contains(5), "contains(5)");
            test.assertTrue(queue.containsAll(queue), "containsAll(self)");
            test.assertFalse(queue.iterator().hasNext(), "iterator().hasNext()");
            test.assertTrue(Arrays.deepEquals(queue.toArray(), new Object[] {}), "toArray()");
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
            test.assertEqual(queue.dequeue(), 1f, "dequeue()");
            test.assertEqual(queue.dequeue(), 2f, "dequeue()");
            test.assertEqual(queue.dequeue(), 3f, "dequeue()");
            test.assertEqual(queue.front(), 4f, "front()");
            test.assertEqual(queue.dequeue(), 4f, "dequeue()");
            test.assertEqual(queue.dequeue(), 5f, "dequeue()");
            test.assertEqual(queue.front(), null, "front()");
            test.assertEqual(queue.dequeue(), null, "dequeue()");
        }
        test.done();
    }
}
