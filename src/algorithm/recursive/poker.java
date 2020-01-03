package algorithm.recursive;

import java.util.Arrays;

public class poker {
    public static void main(String[] args) {
        poker p =new poker();
        p.recursive(1);
        p.print();

    }
    private int p[];
    public poker() {
        p =new int[52];
        for (int i=0;i<52;i++)
            p[i]=0;
        System.out.println("初始状态：0代表poker为上"+Arrays.toString(p));
    }
    public void recursive(int n){
        if (n>52)// 递归出口，（递归函数的参数作用：n只是当作计数任务，不参与运算）
            return;
        for (int j=n;j<52;j++) //扑克翻转规则
            if ((j+1)%(n+1)==0){
                p[j]=(p[j]==0?1:0);
            }
        recursive(n+1);// 调用自身，求解相同的子问题
    }
    public void print(){
        System.out.println("翻转状态：0代表poker为上"+Arrays.toString(p));
    }
}
