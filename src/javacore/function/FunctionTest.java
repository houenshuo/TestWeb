package javacore.function;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer,Integer> function =(p)-> p*10;// function用于接收一个lamba的函数对象
        System.out.println(function.apply(10));
    }
}
