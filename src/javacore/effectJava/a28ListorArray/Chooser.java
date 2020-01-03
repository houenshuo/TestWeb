package javacore.effectJava.a28ListorArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    private final T[] choiceArray;

    public Chooser(Collection<T> choiceArray) {
         //choiceArray =new ArrayList();
        // 泛型数组是不合法的创建（违反泛型的原则，编译不出错，运行肯定不出错，但是泛型数组会违反）,所以这里用choiceArray.toArray()创建一个数组
        // 但是返回的是Object类型 ,这里使用的是T【】 所以要加强制转换，否者报错。
        // 加上强制转换以后，符合了泛型数组转换。但是在运行时，(T[])会擦除，也就没有类型转换了，那么这句代码就不会进行类型转换，也就没有运行时检查转换
        @SuppressWarnings("unchecked") T[] choiceArray1 = (T[])choiceArray.toArray();
        this.choiceArray =choiceArray1;
    }
    public T choose(){
        Random random = ThreadLocalRandom.current();
        return choiceArray[random.nextInt(choiceArray.length)];
    }

    public static void main(String[] args) {
        Collection collection =new ArrayList();
        collection.add("dawsfedfdgrdf");
        // 这里设置Long并不是说把T转为Long，运行时T就是Object类型的，这里Long只是为了编译器检查
        Chooser<Long> chooser =new Chooser<Long>(collection);//Collection<T> choiceArray=new ArrayList();合法
        System.out.println(chooser.choose());//?
    }

}
