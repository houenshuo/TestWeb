package algorithm.backtracking.EightQueens;
/**
 * 1 先放置第一个皇后在第一行的第一列
 * 2 放置第二个皇后在第二行的第一列，判断是否产生规则冲突，如果冲突，则放在第二列、第三列 ，依次类推直到不冲突为止，才开始放下一个皇后。
 * 3 当第八个皇后放在第8行的某列后没有产生冲突，此时就产生了一个八皇后的解。然后在把第8个皇后在剩余列的位置试探完，并得出不冲突的解。
 *   然后开始回溯，返回第7个皇后，这个皇后按照2方法试探剩下的列是否冲突，然后在使用第3个方法，把当前皇后后面的皇后试探完毕。
 * 4 一直回溯到第一个皇后时，第一个皇后放在第一行第一列的所有解法都已经得出。然后在把它放在第二列，使用1，2，3 方法得出第二列的
 * 所有解，依次类推，直到第8列都放完，即可得出所有的解。
 */
public class EightQueens {
    private int size =8;
    private int array[] =new int[size];// 存放8皇后的一个解(数组元素是棋盘列位置、索引是棋盘的行位置也代表第n个皇后)
    private static int count =0;// 解法次数
    private static int judgeCount =0;// 判断次数
    public static void main(String[] args) {
        EightQueens eightQueens =new EightQueens();
        eightQueens.check(0);
        System.out.printf("一共%d种解法",count);
        System.out.printf("一共%d次判断",judgeCount);
    }
    /**
     * 依次放置皇后的位置 得到所有的解
     * @param n 代表第n个皇后
     */
    public void check(int n){
        if (n==size){// 递归出口
            printf();//输出八皇后的解
            count++;
            return;
        }
        for (int i=0;i<size;i++){// 放置当前皇后的列位置（共8列个位置）
            array[n] =i;// 当前皇后放在第i列
            if (judge(n))// 当前皇后找到一个不冲突的位置
                check(n+1);//放置下一个皇后
        }
    }
    /***
     * 判断冲突方法
     * @param n 代表 第n个皇后
     */
    public boolean judge(int n){
        judgeCount++;
        for (int i=0;i<n;i++){// 当前皇后与前n-1个皇后（行）位置进行位置的冲突判断
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n]-array[i]))
                return false;
        }
        return true;
    }
    public void printf(){
        for (int i =0;i<size;i++)
            System.out.print(array[i]);
        System.out.print("\n");
    }
}
