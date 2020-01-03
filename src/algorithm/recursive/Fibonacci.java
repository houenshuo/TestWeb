package algorithm.recursive;

import java.util.Date;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci =new Fibonacci();
        long start =System.currentTimeMillis();
        fibonacci.nonRecursive(50);
        long end =System.currentTimeMillis();
        System.out.println();
        System.out.println("非递归算法时间"+(end-start)+"ms");
        start =System.currentTimeMillis();
        System.out.print(fibonacci.recursive(50));
        end =System.currentTimeMillis();
        System.out.println("递归算法时间"+(end-start)+"ms");
    }
    public long recursive(int n){
        long sum =0;
        if (n == 1 || n ==2)
            return n-1;
        else {
            sum =recursive(n-2)+recursive(n-1);
            return sum;
        }
    }
    public void nonRecursive(int n){
        long a =0,b=1,sum=0;
        int j=1;
        do{
            System.out.print(sum+" ");
            sum =a+b;
            a =b;
            b=sum;
        }while (++j<n);
    }
}
