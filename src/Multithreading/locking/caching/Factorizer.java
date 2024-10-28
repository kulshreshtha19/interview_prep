package Multithreading.locking.caching;

import java.math.BigInteger;

public interface Factorizer {
    public void service(BigInteger reqInt) throws InterruptedException;
}
