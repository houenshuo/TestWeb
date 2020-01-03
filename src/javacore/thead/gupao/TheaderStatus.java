package javacore.thead.gupao;

import java.util.concurrent.TimeUnit;

/**
 * 线程的状态
 */
public class TheaderStatus  {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                while (true){
                    TimeUnit.SECONDS.sleep(1000);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        },"TheaderStatus-Time-wait").start();

        new Thread(()->{
            while (true){
                synchronized (TheaderStatus.class){
                    try {
                        TheaderStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"TheaderStatus-wait").start();

        new Thread(new ThreadDemo(),"ThreadDemo-Block-01").start();
        new Thread(new ThreadDemo(),"ThreadDemo-Block-02").start();
    }
    static class ThreadDemo extends Thread{
        @Override
        public void run() {
            synchronized (ThreadDemo.class){
                    while (true){
                        try {
                            TimeUnit.SECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    }
}
