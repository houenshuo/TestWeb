package javacore.effectJava.a17minChange;

public final class Test {
    private final Object[] s =new Object[]{"1","2"};

    public Object[] getS() {
        return s;
    }

    public static void main(String[] args) {
        Test t =new Test();
        Object[] o =t.getS();//确保对于任何可变组件的互斥访问，使用保护性拷贝技术
        o[0]="iji";
        System.out.println((String) o[0]);
        System.out.println((String) t.getS()[0]);
    }
}
