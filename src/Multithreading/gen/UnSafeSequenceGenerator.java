package Multithreading.gen;

public class UnSafeSequenceGenerator implements SequenceGenerator {
    private long value = 1;

    public long getNext() {
        return value++;
    }
}
