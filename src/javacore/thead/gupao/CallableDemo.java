package javacore.thead.gupao;

import java.util.concurrent.*;

/**
 * 带返回值的线程
 */
public class CallableDemo implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);// 线程池
        CallableDemo callableDemo =new CallableDemo();
        Future<String> future =executorService.submit(callableDemo);// 执行带返回值的线程  execute执行Runnable接口的线程
        System.out.println(future.get());
        executorService.shutdown();
    }
    @Override
    public String call() throws Exception {
        return "带返回值";
    }
}
