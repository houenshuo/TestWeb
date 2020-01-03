package javacore.effectJava.equals10.Transitivity;

import java.util.concurrent.atomic.AtomicInteger;

public class Counterpoint  extends Point{
    private static AtomicInteger atomicInteger =new AtomicInteger();

    public Counterpoint(int x, int y) {
        super(x, y);
        atomicInteger.incrementAndGet();
    }
    static int numberCreated(){
        return atomicInteger.get();
    }
}
