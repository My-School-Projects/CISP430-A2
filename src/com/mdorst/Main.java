package com.mdorst;

import com.mdorst.container.list.LinkedList;
import com.mdorst.container.list.SortedList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        TestRunner test = new TestRunner();
        test.verbose = true;
        /**
         * ==============
         * LinkedList
         * ==============
         */
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
        /**
         * ==========
         * SortedList
         * ==========
         */
        {
            test.log("==================");
            test.log("SortedList<Double>");
            test.log("==================");
            SortedList<Double> list = new SortedList<>();
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
        test.done();
    }
}
