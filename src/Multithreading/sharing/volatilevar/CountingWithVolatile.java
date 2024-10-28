package Multithreading.sharing.volatilevar;

public class CountingWithVolatile {
    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep)
            countSome();
    }

    void countSome() {
        // One, two, three...
    }
}
