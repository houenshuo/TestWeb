package algorithm.recursive;

public class Recursive {
    public static void main(String[] args) {
        int flag =isArrayInSortOrder(new int[]{1,2,3,4,5},5);
        System.out.println(flag);
    }
    // 判断数组中的元素是否有序
    public static int isArrayInSortOrder(int []a,int index){
        if (index ==1)
            return 1;
        else
            return (a[index-1]<=a[index-2])?0:isArrayInSortOrder(a,index-1);
    }
    // 二进制串 ：产生所有的二进制串

}
