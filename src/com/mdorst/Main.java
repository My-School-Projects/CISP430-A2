package com.mdorst;

import com.mdorst.container.list.ListCollection;

public class Main {

    public static void main(String[] args) {
        TestLogger test = new TestLogger();
        ListCollection<Integer> list = new ListCollection<>();
        test.assertEqual(list.size(), 0, "list.size() should be 0 after construction");
        test.assertTrue(list.isEmpty(), "list.isEmpty() should be true after construction");
        test.assertFalse(list.contains(5), "list.contains(5) should be false after construction");
        list.add(5);
        test.assertEqual(list.size(), 1, "list.size() should be 1 after calling add()");
        test.assertTrue(list.contains(5), "list.contains(5) should be true after calling add(5)");
        test.assertTrue(list.containsAll(list), "list.containsAll(list) should always be true");
        test.done();
    }
}
