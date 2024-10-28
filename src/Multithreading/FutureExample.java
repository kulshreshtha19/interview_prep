package Multithreading;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submitting multiple tasks
        Future<String> future1 = executor.submit(() -> {
            Thread.sleep(100); // Simulate a long-running task
            return "Result from Task 1";
        });

        Future<String> future2 = executor.submit(() -> {
            Thread.sleep(10000); // Simulate a shorter task
            System.out.println("Waiting Completed");
            return "Result from Task 2";
        });

        // Calling get on the first Future
        System.out.println("Calling get on future1");
        String result1 = future1.get(); // This will block for 2 seconds
        System.out.println(result1); // Prints result after future1 completes

        // Calling get on the second Future
//        System.out.println("Calling get on future2");
//        String result2 = future2.get(); // This will block for 1 second
//        System.out.println(result2); // Prints result after future2 completes

        executor.shutdown(); // Shutdown the executor service
        Thread.currentThread().stop();
    }
}

