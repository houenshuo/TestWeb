package javacore.effectJava.a31;

import java.util.List;

public class Swap {

    public static void swap(List<?> list,int i,int j){
        // 你不能将null之外的任何值放到List<?>中
        //list.set(i,list.se(j,list.get(i)));
        // ？代表未知类型，E代表E类型
        swapHelper(list,i,j);
    }
    private static <E> void swapHelper(List<E> list,int i,int j){
        list.set(i,list.set(j,list.get(i)));
    }
}
