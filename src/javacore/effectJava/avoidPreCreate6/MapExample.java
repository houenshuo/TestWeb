package javacore.effectJava.avoidPreCreate6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<String,String> map =new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        map.put("4","1");
        map.put("5","1");
        map.put("6","1");
        Set<String> sets =map.keySet();
        System.out.println(System.identityHashCode(sets));//284720968
        Set<String> strings =map.keySet();
        System.out.println(System.identityHashCode(strings));//284720968
        /**
         * 每次返回的set对象 都是一样的，并不是每次返回的都是新的。
         * 因为 这没有必要返回新的对象
         * jdk 的map源码中 是有一个transient Set<K>        keySet;属性，每次返回set就是返回他的引用
         */

    }
}
