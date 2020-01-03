package javacore.effectJava.a29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private Object[] objects;
    private int size =0;
    private static final int length =16;

    public Stack() {
        //objects =new E[length];//修改为泛型类 会出现这一个错误,不能new 因为违反泛型原则，如果可以的话 就没办法引入泛型
        /**
         * 做法一 优先 但是导致堆污染
         */
        //做法一：先创建数组为Object类型的数组 在转为泛型的数组
//        Object o =new Object[length];
//        objects =(E[])o;
        // 做法二 引起
        objects =new Object[length];
    }

    public void push(E e){
        ensureCapacity();
    }

    /**
     * 弹出的元素 并没有被垃圾回收，加入有元素覆盖了index位置元素，旧的元素并不会被垃圾回收
     * @return
     */
    public E pop(){
        if (size==0)
            throw new EmptyStackException();
        return (E)objects[--size];
    }
    public E pop1(){// 消除过期引用的方法
        if (size==0)
            throw new EmptyStackException();
        E object =(E)objects[--size];
        objects[size] =null; // 手动清空为null
        return object;
    }

    private void ensureCapacity() {
        if (objects.length == size)
            objects = Arrays.copyOf(objects,2*size+1);
    }

}
