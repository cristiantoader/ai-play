package com.ctoader.ai.neural.helper;

import java.util.List;

/**
 * Created by crist on 12/11/2016.
 */
public class Validator {

    public static <T> void checkNotNull(T obj, String message) {
        if (obj == null) {
            throw new RuntimeException(String.format("Unexpected null object %s.", message));
        }
    }

    public static <T> void checkLengths(List<T> foo, List<T> bar, String message) {
        if (foo.size() != bar.size()) {
            throw new RuntimeException(String.format("Error checking %s.", message));
        }
    }
}
