package com.mdorst;

import com.mdorst.container.list.LinkedList;
import com.mdorst.container.list.SortedList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        TestRunner test = new TestRunner();
        /**
         * ==============
         * LinkedList
         * ==============
         */
        {
            Collection<Integer> list = new LinkedList<>();
            test.assertEqual(list.size(), 0, "list.size() should be 0 after construction");
            test.assertTrue(list.isEmpty(), "list.isEmpty() should be true after construction");
            test.assertFalse(list.contains(5), "list.contains(5) should be false after construction");
            test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
            test.assertFalse(list.iterator().hasNext(), "list.iterator().hasNext() should be false for an empty list");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {}), "list.toArray() should be an empty array");
            list.add(5);
            test.assertEqual(list.size(), 1, "list.size() should be 1 after calling add() once");
            test.assertFalse(list.isEmpty(), "list.isEmpty() should be false after construction");
            test.assertTrue(list.contains(5), "list.contains(5) should be true after calling add(5)");
            test.assertFalse(list.contains(2), "list.contains(2) should be false before calling add(2)");
            test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
            test.assertTrue(list.iterator().hasNext(), "list.iterator().hasNext() should be true for a non-empty list");
            Iterator<Integer> iter = list.iterator();
            test.assertTrue(iter.hasNext(), "iter.hasNext() should be true");
            test.assertEqual(iter.next(), 5, "iter.next() should be 5");
            test.assertEqual(iter.next(), null, "iter.next() should be null");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(list.toArray().length, 1, "list.toArray() should return an array of length 1");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {5}), "list.toArray should == {5}");
            list.add(2);
            test.assertEqual(list.size(), 2, "list.size() should be 2 after calling add() twice");
            test.assertTrue(list.contains(5), "list.contains(5) should be true after calling add(5)");
            test.assertTrue(list.contains(2), "list.contains(2) should be true after calling add(2)");
            test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
            test.assertTrue(list.iterator().hasNext(), "list.iterator().hasNext() should be true for a non-empty list");
            iter = list.iterator();
            test.assertEqual(iter.next(), 5, "iter.next() should be 5");
            test.assertEqual(iter.next(), 2, "iter.next() should be 2");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(list.toArray().length, 2, "list.toArray() should return an array of length 2");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {5, 2}), "list.toArray should == {5, 2}");
            {
                LinkedList<Integer> list2 = new LinkedList<>();
                list2.add(11);
                list2.add(3);
                list2.add(115);
                list.addAll(list2);
            }

            test.assertTrue(list.contains(11), "list.contains(11) should be true after call to addAll()");
            test.assertTrue(list.contains(3), "list.contains(3) should be true after call to addAll()");
            test.assertTrue(list.contains(115), "list.contains(115) should be true after call to addAll()");
            iter = list.iterator();
            test.assertEqual(iter.next(), 5, "iter.next() should be 5");
            test.assertEqual(iter.next(), 2, "iter.next() should be 2");
            test.assertEqual(iter.next(), 11, "iter.next() should be 11");
            test.assertEqual(iter.next(), 3, "iter.next() should be 3");
            test.assertTrue(iter.hasNext(), "iter.hasNext() should be true");
            test.assertEqual(iter.next(), 115, "iter.next() should be 115");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(iter.next(), null, "iter.next() should be null");
        }
        /**
         * ==========
         * SortedList
         * ==========
         */
        {
            SortedList<Double> list = new SortedList<>();
            test.assertEqual(list.size(), 0, "list.size() should be 0 after construction");
            test.assertTrue(list.isEmpty(), "list.isEmpty() should be true after construction");
            test.assertFalse(list.contains(5), "list.contains(5) should be false after construction");
            test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
            test.assertFalse(list.iterator().hasNext(), "list.iterator().hasNext() should be false for an empty list");
            test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {}), "list.toArray() should be an empty array");
            list.add(5.0);
            test.assertEqual(list.size(), 1, "list.size() should be 1 after calling add() once");
            test.assertFalse(list.isEmpty(), "list.isEmpty() should be false after construction");
            test.assertTrue(list.contains(5.0), "list.contains(5) should be true after calling add(5.0)");
            test.assertFalse(list.contains(2.0), "list.contains(2) should be false before calling add(2.0)");
            test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
            test.assertTrue(list.iterator().hasNext(), "list.iterator().hasNext() should be true for a non-empty list");
            Iterator<Double> iter = list.iterator();
            test.assertEqual(iter.next(), 5.0, "iter.next() should be 5.0");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(iter.next(), null, "iter.next() should be null");
            list.add(2.0);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "iter.next() should be 2.0");
            test.assertEqual(iter.next(), 5.0, "iter.next() should be 5.0");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(iter.next(), null, "iter.next() should be null");
            list.add(10.0);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "iter.next() should be 2.0");
            test.assertEqual(iter.next(), 5.0, "iter.next() should be 5.0");
            test.assertEqual(iter.next(), 10.0, "iter.next() should be 10.0");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(iter.next(), null, "iter.next() should be null");
            list.add(4.9);
            iter = list.iterator();
            test.assertEqual(iter.next(), 2.0, "iter.next() should be 2.0");
            test.assertEqual(iter.next(), 4.9, "iter.next() should be 4.9");
            test.assertEqual(iter.next(), 5.0, "iter.next() should be 5.0");
            test.assertEqual(iter.next(), 10.0, "iter.next() should be 10.0");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(iter.next(), null, "iter.next() should be null");
            list.add(1.5);
            iter = list.iterator();
            test.assertEqual(iter.next(), 1.5, "iter.next() should be 1.5");
            test.assertEqual(iter.next(), 2.0, "iter.next() should be 2.0");
            test.assertEqual(iter.next(), 4.9, "iter.next() should be 4.9");
            test.assertEqual(iter.next(), 5.0, "iter.next() should be 5.0");
            test.assertEqual(iter.next(), 10.0, "iter.next() should be 10.0");
            test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
            test.assertEqual(iter.next(), null, "iter.next() should be null");
        }
        test.done();
    }
}
