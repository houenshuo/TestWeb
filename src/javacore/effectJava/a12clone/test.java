package javacore.effectJava.a12clone;

public class test {
    public static void main(String[] args) {
        String s[] =new String[]{"da","fasf"};
        String s1[] =s.clone();
        s1[0] ="1";
        System.out.println(s1[0]+"  "+s[0]);

        A[] a =new A[]{new A(1),new A(2)};
        A[] a1 =a.clone();
        a1[0].num =3;
        System.out.println(a[0].num+"  "+a1[0].num);

    }
    static class A {
        int num;

        public A(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}
