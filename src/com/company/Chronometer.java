package com.company;

/**
 * Created by Ирина on 09.02.2017.
 */
public class Chronometer {
    private static long pointOfStart = System.currentTimeMillis();
    public static final Object lock = new Object();
    public static boolean ready = false;

    public static long getPointOfStart() {
        return pointOfStart;
    }

    public static void setPointOfStart(long pointOfStart) {
        Chronometer.pointOfStart = pointOfStart;
    }

    public static long getTimeSinceStartSession() {
        long timeSinceStartSession = System.currentTimeMillis() - pointOfStart;
        synchronized (lock) {
            try {
                if (!ready) {
                    lock.wait();
                    timeSinceStartSession = System.currentTimeMillis() - pointOfStart;
                    //lock.notify(); // ежесекундное оповещение
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return timeSinceStartSession;
        }
    }


    public static void printTimeSinceStartSession() {
        synchronized (lock) {
            ready = true;
            System.out.println(getTimeSinceStartSession());
            lock.notifyAll();
        }
    }
}
