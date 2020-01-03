package javacore.thead.gupao;

public class ThreadVisibility {
    private volatile static boolean isFlag =true;//volatile保证可见性：多个线程对共享数据操作。当主线程对共享数据修改时 ，线程不能
    // 及时的获取，则成为不可见性。原因是
    // 高速缓存（加入高速缓存的目的是为了cpu最大化利用，所以使用缓存同步数据，此时线程可以使用cpu资源
    // 读主内存数据，读到的不是最新修改后的，最新的还在缓存中没同步，如果加入关键字则让cpu阻塞 避免错误的计算）
    // 高速缓存带来的问题 就是 指令重排序 然后会出现 可见性
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(()->{
            try {
                int i =0;
                while (isFlag){
                    System.out.println(i++);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(1000);
        isFlag =false;

    }
}
