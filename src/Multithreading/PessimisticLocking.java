package Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class PessimisticLocking {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100000];

        for (int i = 0; i < 100000; i++) {
            threads[i] = new Thread(() -> {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter with lock (pessimistic locking): " + counter);
    }
}
