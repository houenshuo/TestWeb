package algorithm.recursive;

public class Targeting {
    public static void main(String[] args) {
        Targeting t =new Targeting();
        t.socre45(6,0);
        t.printCount();
    }
    private int count=0;
    public void socre45(int n,int sum){
        //参数 肯定要用于递归出口，参数n和n—1相当于一层循环
        if (n<0)
            return;
        else if((45-sum)>(10*n))// 假设剩余次数满环的情况下
            return;
        else if (sum==45 && n==0){
            count++;
            return;
        }
        for (int i=0;i<11;i++){
            socre45(n-1,sum+i);
        }
    }
    public void printCount(){
        System.out.println("6枪打中45环的次数为："+count);
    }
}
