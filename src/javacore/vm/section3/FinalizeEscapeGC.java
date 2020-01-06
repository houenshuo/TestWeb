package javacore.vm.section3;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK =null;
    public  void isAlive(){
        System.out.printf("yes,t am still live");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK =this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK =new FinalizeEscapeGC();

        SAVE_HOOK =null;
        System.gc();
        Thread.sleep(50);// finalize优先级很低，会加入一个队列中慢慢执行，有可能执行，也有可能不被执行

        if (SAVE_HOOK!=null)
            SAVE_HOOK.isAlive();
        else
            System.out.printf("no ");


        /**
         * 第二次 自我救赎总是失败
         *  因为对任何一个对象finalize方法最多调用一次。
         */
        SAVE_HOOK =null;
        System.gc();
        Thread.sleep(50);// finalize优先级很低，会加入一个队列中慢慢执行，有可能执行，也有可能不被执行

        if (SAVE_HOOK!=null)
            SAVE_HOOK.isAlive();
        else
            System.out.printf("no ");


    }
}
