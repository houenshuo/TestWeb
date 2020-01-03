package javacore.effectJava.avoidPreCreate6;

public class StringExample {
    public static void main(String[] args) {
        String s =new String("bikini");// 不要这样做
        String s1 ="bikini";// 这样做
    }
}
