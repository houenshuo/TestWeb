package javacore.effectJava.a39;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {
    @ExceptionTest({IndexOutOfBoundsException.class,NullPointerException.class})
    public static void m1(){
        List<String> list =new ArrayList<>();
        list.add(5,null);
    }

    @ExcepationTest1(IndexOutOfBoundsException.class)
    @ExcepationTest1(NullPointerException.class)
    public static void m2(){
        List<String> list =new ArrayList<>();
        list.add(5,null);
    }
}
