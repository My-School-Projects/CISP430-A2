package com.mdorst;

import com.mdorst.container.list.ListCollection;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        TestLogger test = new TestLogger();
        ListCollection<Integer> list = new ListCollection<>();
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
        test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
        test.assertTrue(list.iterator().hasNext(), "list.iterator().hasNext() should be true for a non-empty list");
        test.assertEqual(list.iterator().next(), 5, "list.iterator().next() should be 5");
        test.assertEqual(list.toArray().length, 1, "list.toArray() should return an array of length 1");
        test.assertTrue(Arrays.deepEquals(list.toArray(), new Object[] {5}), "list.toArray should == {5}");
        list.add(2);
        test.assertEqual(list.size(), 2, "list.size() should be 2 after calling add() twice");
        test.assertTrue(list.contains(5), "list.contains(5) should be true");
        test.assertTrue(list.contains(2), "list.contains(2) should be true");
        test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
        test.assertTrue(list.iterator().hasNext(), "list.iterator().hasNext() should be true for a non-empty list");
        Iterator<Integer> iter = list.iterator();
        test.assertEqual(iter.next(), 5, "iter.next() should be 5");
        test.assertEqual(iter.next(), 2, "iter.next() should be 2");
        test.assertFalse(iter.hasNext(), "iter.hasNext() should be false");
        test.done();
    }
}
