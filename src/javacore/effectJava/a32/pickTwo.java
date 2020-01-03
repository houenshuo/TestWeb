package javacore.effectJava.a32;

import java.util.concurrent.ThreadLocalRandom;

public class pickTwo {
    public static void main(String[] args) {
        // 运行出错 pickTwo是返回Object数组 却用String[]接受 对泛型方法加强制转换时没用的
        String[] attributes =(String[]) pickTwo("good","fast","cheap");

    }

    private static <T>T[] toArray(T... args){
        return args;// 内部用Object数组 存储args 返回也是返回Object的数组
    }
    static <T> T[] pickTwo(T a,T b,T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0:return toArray(a,b);// 也是返回Object数组
            case 1:return toArray(a,c);
            case 2:return toArray(b,c);
        }
        throw new AssertionError();
    }
}
