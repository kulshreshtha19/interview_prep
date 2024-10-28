package Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String args[]) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i=1;i<=3;i++) {
            new Thread(new Worker(countDownLatch)).start();
        }

        countDownLatch.await();
        System.out.println(".... All threads completed ....");
    }
}

class Worker implements Runnable {

    CountDownLatch countDownLatch;

    Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            countDownLatch.countDown();
        }
    }
}
