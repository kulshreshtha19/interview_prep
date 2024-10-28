package Multithreading;

import java.util.concurrent.CompletableFuture;

class CompletableFutureExample {
    public static void main(String[] args) {
        // Start two asynchronous tasks
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from Task 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from Task 2";
        });

        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            try {
               String result = new WorkerExample().call();
               System.out.println(result);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        // Combine the results and define a callback to process the final result
        future1.thenCombine(future2, (result1, result2) -> result1 + " + " + result2)
                .thenAccept(finalResult -> {
                    System.out.println("Final combined result (non-blocking): " + finalResult);
                });

        // Main thread can continue doing other tasks and will not wait for the futures to complete
        System.out.println("Main thread continues without waiting.");

//        future1.join();
//        future2.join();
//        future3.join();
    }
}


class WorkerExample {
    public String call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Result from worker3";
    }
}

