package algorithm.recursive;

import java.util.Scanner;

public class conversion {
    public static void main(String[] args) {
        conversion conversion =new conversion();
        Scanner scanner =new Scanner(System.in);
        int n =scanner.nextInt();
        if (n>90000) {
            System.out.println("error");
            return;
        }
        System.out.println("递归算法：");
        conversion.convert(n);
        System.out.println();
        System.out.println("非递归算法");
        conversion.convert2(n);
    }
    // 递归算法
    public void convert(int n){
        if (n == 0){
            return;
        }else {
            convert(n/2);
            System.out.print(n%2);
        }
    }
    // 非递归算法
    public void convert2(int n){
        StringBuffer stringBuffer =new StringBuffer();
        while (n>0){
            stringBuffer.append(n%2);
            n/=2;
        }
        System.out.println(stringBuffer.reverse().toString());
    }
}
