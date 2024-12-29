package com.systemdesign.producerconsumer;

public class BufferManager {

    private final int[] buffer;
    private final int MAX_BUFFER_SIZE;

    private int currIndex;

    BufferManager(int maxBufferSize) {
        this.buffer = new int[maxBufferSize];
        this.MAX_BUFFER_SIZE = maxBufferSize;
        this.currIndex = -1;
    }

    public synchronized void produce(int val) {
        while (this.currIndex == MAX_BUFFER_SIZE) {
            try {
                System.out.println(Thread.currentThread().getName() + " " + "Buffer size is full");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.buffer[++currIndex] = val;
        System.out.println(Thread.currentThread().getName() + " produced item successfully " + val + " index " + currIndex);
        notify();
    }

    public synchronized void consumer() {
        while (this.currIndex == -1) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to consume" );
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(Thread.currentThread().getName()
                + " at index " + currIndex + " consumed successfully value " + this.buffer[currIndex--]);
        notify();
    }
}
