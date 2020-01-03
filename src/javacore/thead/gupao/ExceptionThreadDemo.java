package javacore.thead.gupao;

import java.util.concurrent.TimeUnit;

/**
 * 中断线程
 */
public class ExceptionThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(()->{
           while (!Thread.currentThread().isInterrupted()){// 默认是false 没有中断
               try {
                   TimeUnit.SECONDS.sleep(1);// 睡眠 -》也就是正在block状态
                   System.out.println("任务执行");
               } catch (InterruptedException e) {// 如果在block状态时 被中断，那么就会先复位 在抛出异常
                   e.printStackTrace();
                   // 这里可以进行在异常抛出之后的一些处理
                   // 比如 退出当前循环 结束线程
                   break;
               }
           }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }
}
