package com.company;

/**
 * Created by Ирина on 09.02.2017.
 */
public class Chronometer {
    private static long pointOfStart = System.currentTimeMillis();
    public static final Object lock = new Object();

    public static long getTimeSinceStartSession() {
        long timeSinceStartSession;
        synchronized (lock) {
            timeSinceStartSession = System.currentTimeMillis() - pointOfStart;
        }

        return timeSinceStartSession;
    }

    public static long 
}
