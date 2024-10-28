package Multithreading.locking.timed;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * TimedLockingExample
 * Locking with a time budget
 *
 * @author manish.ranglani
 */
public class TimedLockingExample {
    private Lock lock = new ReentrantLock();

    public boolean trySendOnSharedLine(String message, long timeout, TimeUnit unit)
            throws InterruptedException {
        long nanosToLock = unit.toNanos(timeout) - getMsgLength(message);
        if (!lock.tryLock(nanosToLock, NANOSECONDS))
            return false;
        try {
            return doSomeThing(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean doSomeThing(String message) {
        /* do something */
        return true;
    }

    long getMsgLength(String message) {
        return message.length();
    }
}
