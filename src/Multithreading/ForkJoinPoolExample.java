package Multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(); // Create a ForkJoinPool

        // Create and invoke a task that calculates the sum of numbers from 1 to 10,000
        int result = forkJoinPool.invoke(new SumTask(1, 10000));
        System.out.println("Sum: " + result);
    }
}

class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 1000;
    private int start, end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= THRESHOLD) {
            // If the task is small enough, compute directly
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // Split the task into smaller subtasks
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(start, mid);
            SumTask rightTask = new SumTask(mid + 1, end);

            // Fork the subtasks
            leftTask.fork();
            rightTask.fork();

            // Join the results
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // Combine the results
            return leftResult + rightResult;
        }
    }
}

