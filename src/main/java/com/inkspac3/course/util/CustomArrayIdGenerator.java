package com.inkspac3.course.util;

public class CustomArrayIdGenerator {
    private static long counter = 0;

    private CustomArrayIdGenerator() {}

    public static long generateId() {
        counter++;
        return counter;
    }
}
