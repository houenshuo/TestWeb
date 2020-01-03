package javacore.effectJava.a28ListorArray;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //数组是协变的，超类可以接受子类的对象
        Object o[] =new Long[1];
        o[0]="qwe";// 错误的使用

        // 列表 则不会出现这种错误
        List<Long> longs =new ArrayList<>();
        List[] lists =new List[1];
        //List<T>[] lists1 =new List[1];
    }
}
