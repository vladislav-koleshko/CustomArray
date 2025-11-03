package com.inkspac3.util;

import java.util.concurrent.atomic.AtomicLong;

public class CustomArrayIdGenerator {
    private static final AtomicLong counter = new AtomicLong(0);

    private CustomArrayIdGenerator() {}

    public static long generateId() {
        return counter.incrementAndGet();
    }
}
