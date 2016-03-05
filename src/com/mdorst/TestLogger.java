package com.mdorst;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class serves as a simple testing framework.
 * <p>
 * Calls to {@code assert*} are tracked, and error messages are stored
 * for a later call to {@code finalize()}, which will either print
 * "Passed!" or "Failed." and a list of failed assertions if applicable.
 */
public class TestLogger {
    private List<String> log;
    PrintStream stream;

    public void assertTrue(boolean assertion, String error) {
        if (assertion) {
            stream.print(".");
        } else {
            stream.print("F");
            log.add(error);
        }
    }

    public void assertTrue(boolean assertion) {
        assertTrue(assertion, "Invalid assertion");
    }

    public void assertEqual(Object o1, Object o2, String error) {
        assertTrue(Objects.equals(o1, o2), error);
    }

    public void assertEqual(Object o1, Object o2) {
        assertTrue(Objects.equals(o1, o2));
    }

    /**
     * Prints "Passed!" or "Failed." depending on weather there are
     * errors or not, and displays any error messages
     */
    public void done() {
        stream.println();
        if (log.isEmpty()) {
            stream.println("Passed!");
        } else {
            stream.println("Failed.");
        }
        log.forEach(stream::println);
    }

    public TestLogger(PrintStream ps) {
        stream = ps;
        log = new LinkedList<>();
    }

    public TestLogger() {
        this(System.out);
    }
}