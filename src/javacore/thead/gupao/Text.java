package javacore.thead.gupao;

import java.util.concurrent.locks.LockSupport;

public class Text {
    public static void main(String[] args) throws InterruptedException {
        Object o =new Object();

        A a =new A(o);
        a.start();

        System.out.println("主线程");
        synchronized (o){
            o.notify();
        }
        System.out.println("释放A");
    }

}
class A extends Thread implements  Runnable{
    private Object o;
    public A(Object o) {
        this.o =o;
    }

    @Override
    public void run() {
        synchronized (o) {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1");
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
            }
        }
    }
}