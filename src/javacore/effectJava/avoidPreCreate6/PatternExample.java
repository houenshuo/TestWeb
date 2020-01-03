package javacore.effectJava.avoidPreCreate6;

import java.util.regex.Pattern;

public class PatternExample {
    private static final Pattern pattern=Pattern.compile("[0-9]");// 静态工厂方法代替构造器
    public static boolean isRomanNumber(String s){
        return s.matches("[0-9]");// jdk对Pattern的封装  但是每次都会创建新的Pattern对象。（Pattern对于string来说是一个附加品，而Map中返回set却不同）
    }
    public static boolean isNumber(String s){// 公用一个 pattern 缺点就是 需要自己编写Pattern创建，而不用jdk封装好的
        return pattern.matcher(s).matches();
    }
}
