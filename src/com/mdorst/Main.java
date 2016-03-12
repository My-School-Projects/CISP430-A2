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
            test.assertEqual(list.size(), 0, "size() should be 0 after construction");
            test.assertTrue(list.isEmpty(), "isEmpty() should be true after construction");
            test.assertFalse(list.contains(5), "contains(5) should be false after construction");
            test.assertTrue(list.containsAll(list), "containsAll(self) should always be true");
            test.assertFalse(list.iterator().hasNext(), "iterator().hasNext() should be false for an empty list");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {}), "toArray() should be an empty array");
            test.log("add(5)");
            list.add(5);
            test.assertEqual(list.size(), 1, "size() should be 1 after calling add() once");
            test.assertFalse(list.isEmpty(), "isEmpty() should be false after construction");
            test.assertTrue(list.contains(5), "contains(5) should be true after calling add(5)");
            test.assertFalse(list.contains(2), "contains(2) should be false before calling add(2)");
            test.assertTrue(list.containsAll(list), "containsAll(self) should always be true");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext() should be true for a non-empty list");
            test.log("=================");
            test.log("Iterator<Integer>");
            test.log("=================");
            Iterator<Integer> iter = list.iterator();
            test.assertTrue(iter.hasNext(), "hasNext() should be true");
            test.assertEqual(iter.next(), 5, "next() should be 5");
            test.assertEqual(iter.next(), null, "next() should be null");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(list.toArray().length, 1, "toArray() should return an array of length 1");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {5}), "toArray should == {5}");
            test.log("add(2)");
            list.add(2);
            test.assertEqual(list.size(), 2, "size() should be 2 after calling add() twice");
            test.assertTrue(list.contains(5), "contains(5) should be true after calling add(5)");
            test.assertTrue(list.contains(2), "contains(2) should be true after calling add(2)");
            test.assertTrue(list.containsAll(list), "containsAll(self) should always be true");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext() should be true for a non-empty list");
            test.log("Reset iterator");
            iter = list.iterator();
            test.assertEqual(iter.next(), 5, "next() should be 5");
            test.assertEqual(iter.next(), 2, "next() should be 2");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(list.toArray().length, 2, "toArray() should return an array of length 2");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {5, 2}), "toArray should == {5, 2}");
            test.log("addAll(11, 3, 115)");
            {
                LinkedList<Integer> list2 = new LinkedList<>();
                list2.add(11);
                list2.add(3);
                list2.add(115);
                list.addAll(list2);
            }

            test.assertTrue(list.contains(11), "contains(11) should be true after call to addAll()");
            test.assertTrue(list.contains(3), "contains(3) should be true after call to addAll()");
            test.assertTrue(list.contains(115), "contains(115) should be true after call to addAll()");
            test.log("Reset iterator");
            iter = list.iterator();
            test.assertEqual(iter.next(), 5, "next() should be 5");
            test.assertEqual(iter.next(), 2, "next() should be 2");
            test.assertEqual(iter.next(), 11, "next() should be 11");
            test.assertEqual(iter.next(), 3, "next() should be 3");
            test.assertTrue(iter.hasNext(), "hasNext() should be true");
            test.assertEqual(iter.next(), 115, "next() should be 115");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(iter.next(), null, "next() should be null");
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
            test.assertEqual(list.size(), 0, "size() should be 0 after construction");
            test.assertTrue(list.isEmpty(), "isEmpty() should be true after construction");
            test.assertFalse(list.contains(5), "contains(5) should be false after construction");
            test.assertTrue(list.containsAll(list), "containsAll(self) should always be true");
            test.assertFalse(list.iterator().hasNext(), "iterator().hasNext() should be false for an empty list");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {}), "toArray() should be an empty array");
            test.log("add(5.0)");
            list.add(5.0);
            test.assertEqual(list.size(), 1, "size() should be 1 after calling add() once");
            test.assertFalse(list.isEmpty(), "isEmpty() should be false after construction");
            test.assertTrue(list.contains(5.0), "contains(5) should be true after calling add(5.0)");
            test.assertFalse(list.contains(2.0), "contains(2) should be false before calling add(2.0)");
            test.assertTrue(list.containsAll(list), "containsAll(self) should always be true");
            test.assertTrue(list.iterator().hasNext(), "iterator().hasNext() should be true for a non-empty list");
            test.log("================");
            test.log("Iterator<Double>");
            test.log("================");
            Iterator<Double> iter = list.iterator();
            test.assertEqual(iter.next(), 5.0, "next() should be 5.0");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(iter.next(), null, "next() should be null");
            test.log("add(2.0)");
            test.log("Reset iterator");
            list.add(2.0);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "next() should be 2.0");
            test.assertEqual(iter.next(), 5.0, "next() should be 5.0");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(iter.next(), null, "next() should be null");
            test.log("add(10.0)");
            test.log("Reset iterator");
            list.add(10.0);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "next() should be 2.0");
            test.assertEqual(iter.next(), 5.0, "next() should be 5.0");
            test.assertEqual(iter.next(), 10.0, "next() should be 10.0");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(iter.next(), null, "next() should be null");
            test.log("add(4.9)");
            test.log("Reset iterator");
            list.add(4.9);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "next() should be 2.0");
            test.assertEqual(iter.next(), 4.9, "next() should be 4.9");
            test.assertEqual(iter.next(), 5.0, "next() should be 5.0");
            test.assertEqual(iter.next(), 10.0, "next() should be 10.0");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(iter.next(), null, "next() should be null");
            test.log("add(1.5)");
            test.log("Reset iterator");
            list.add(1.5);
            iter = list.iterator();
            test.assertEqual(iter.next(), 1.5, "next() should be 1.5");
            test.assertEqual(iter.next(), 2.0, "next() should be 2.0");
            test.assertEqual(iter.next(), 4.9, "next() should be 4.9");
            test.assertEqual(iter.next(), 5.0, "next() should be 5.0");
            test.assertEqual(iter.next(), 10.0, "next() should be 10.0");
            test.assertFalse(iter.hasNext(), "hasNext() should be false");
            test.assertEqual(iter.next(), null, "next() should be null");
        }
        test.done();
    }
}
