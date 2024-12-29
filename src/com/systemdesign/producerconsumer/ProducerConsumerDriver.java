package com.systemdesign.producerconsumer;

public class ProducerConsumerDriver {

    public static void main(String[] args) {
        BufferManager bufferManager = new BufferManager(12);

        Thread producer1 = new Thread( () -> bufferManager.produce(1));
        Thread producer2 = new Thread( () -> bufferManager.produce(2));
        Thread producer3 = new Thread( () -> bufferManager.produce(3));
        Thread producer4 = new Thread( () -> bufferManager.produce(4));
        Thread producer5 = new Thread( () -> bufferManager.produce(5));
        Thread producer6 = new Thread( () -> bufferManager.produce(6));

        Thread consumer1 = new Thread(bufferManager::consumer);
        Thread consumer2 = new Thread(bufferManager::consumer);
        Thread consumer3 = new Thread(bufferManager::consumer);
        Thread consumer4 = new Thread(bufferManager::consumer);
        Thread consumer5 = new Thread(bufferManager::consumer);
        Thread consumer6 = new Thread(bufferManager::consumer);
        Thread consumer7 = new Thread(bufferManager::consumer);


        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        producer6.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        consumer6.start();
        consumer7.start();
    }
}
