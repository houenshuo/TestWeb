package javacore.effectJava.avoidPreCreate6;

/**
 * 自动装箱拆箱测试
 */
public class AutoboxingExample {
    public static void main(String[] args) {
        Long sum =0L;
        for (int i=0;i<=Integer.MAX_VALUE;i++){
            sum+=i;// 这意味着构造了2的31次幂的多余的Long实例
        }
        System.out.println(sum);
    }
}
