package javacore.effectJava.a11hashcode;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<PhoneNumber,String> m =new HashMap<>();
        m.put(new PhoneNumber(7,8,5),"jenny");

        System.out.println(m.get(new PhoneNumber(7,8,5)));// 返回null 没有重写hashcode
    }
}
