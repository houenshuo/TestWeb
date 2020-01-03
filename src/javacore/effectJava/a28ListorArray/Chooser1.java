package javacore.effectJava.a28ListorArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser1<T> {
    private final List<T> choiceList;
    //private final List<T> choiceList =new ArrayList<>(); //创建成功列表
    // private T[]= new T[1];// 错误的创建

    public Chooser1(Collection<T> choiceArray) {
        // 这里不存在类型强转，所以不会有警告
        choiceList =new ArrayList(choiceArray);
    }
    public T choose(){
        Random random = ThreadLocalRandom.current();
        return choiceList.get(random.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {

        Collection c =new ArrayList();
        c.add("11");
        Chooser1<Long> chooser1 =new Chooser1<Long>(c);

        System.out.println(chooser1.choose());
    }

}
