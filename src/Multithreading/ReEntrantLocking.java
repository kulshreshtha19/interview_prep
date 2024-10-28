package Multithreading;


import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class worker implements Callable<Integer> {

    Integer counter;
    ReentrantLock reentrantLock = new ReentrantLock();

    worker() {
        this.counter = 0;
    }

    @Override
    public Integer call() throws InterruptedException {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " acquired the lock." + reentrantLock.getHoldCount());
        Thread.sleep(1000);
        this.counter++;

        if (this.counter == 1) {
            call();
        }

        reentrantLock.unlock();
        return this.counter;
    }
}

public class ReEntrantLocking {

    public static void main(String args[]) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            worker worker = new worker();
            Future worker1 = executorService.submit(worker);
            Future worker2 = executorService.submit(worker);
            Future worker3 = executorService.submit(worker);
            Future worker4 = executorService.submit(worker);

            System.out.println(worker1.get());
            System.out.println(worker2.get());
            System.out.println(worker3.get());
            System.out.println(worker4.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }
    }
}
