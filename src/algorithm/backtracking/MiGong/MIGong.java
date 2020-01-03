package algorithm.backtracking.MiGong;

import java.util.Arrays;

public class MIGong {
    private static int map[][];
    public static void main(String[] args) {
        MIGong miGong =new MIGong();
        miGong.MiGong(1,1);
        for (int i=0;i<10;i++)
            System.out.println(Arrays.toString(map[i]));
    }
    public MIGong() {
        // 第一步：生成迷宫
         map =new int[][]{
                {1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,1,0,1},
                {1,1,0,1,1,1,1,1,0,1},
                {1,0,1,0,0,1,0,0,1,1},
                {1,0,0,1,1,0,1,0,1,1},
                {1,0,1,0,0,0,1,1,0,1},
                {1,0,1,1,1,1,1,0,1,1},
                {1,0,0,1,1,1,0,1,1,1},
                {1,1,1,0,0,1,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}
        };
    }
    /**
     * @param i 行位置
     * @param j 列位置
     */
    public boolean MiGong(int i,int j){
        // 如果map[8][8] =0 说明已经走出迷宫
        if (map[8][8] ==2){
            return true;
        }
        // 如果（i，j）位置为0时，代表可以走
        //注：（记号规则：0 有路 1 挡板 2 已走路 3不可走路）
        if (map[i][j] == 0){
            map[i][j] =2;// 先假设走到(i,j)位置 标记为2
            // 在假设(i,j)可走的基础上，判断四个方向是否有路可走
            if (MiGong(i-1,j-1))
                return true;
            else if (MiGong(i-1,j))
                return true;
            else if (MiGong(i-1,j+1))
                return true;
            else if (MiGong(i,j-1))
                return true;
            else if (MiGong(i,j+1))
                return true;
            else if (MiGong(i+1,j-1))
                return true;
            else if (MiGong(i+1,j))
                return true;
            else if (MiGong(i+1,j+1))
                return true;
            else {
                map[i][j] =3;// 四个方向都没有路可走，那么假设错误，标记重新置为3
                return false;
            }
        }else {
            return false;
        }
    }
}
