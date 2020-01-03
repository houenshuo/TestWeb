package javacore.effectJava.ClearObject7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] objects;
    private int size =0;
    private static final int length =16;

    public Stack() {
        objects =new Object[length];
    }

    public void push(Object e){
        ensureCapacity();
    }

    /**
     * 弹出的元素 并没有被垃圾回收，加入有元素覆盖了index位置元素，旧的元素并不会被垃圾回收
     * @return
     */
    public Object pop(){
        if (size==0)
            throw new EmptyStackException();
        return objects[--size];
    }
    public Object pop1(){// 消除过期引用的方法
        if (size==0)
            throw new EmptyStackException();
        Object object =objects[--size];
        objects[size] =null; // 手动清空为null
        return object;
    }

    private void ensureCapacity() {
        if (objects.length == size)
            objects = Arrays.copyOf(objects,2*size+1);
    }
}
