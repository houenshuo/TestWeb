package algorithm.dp;

public class editDistance {
    public static void main(String[] args) {
        System.out.println("kitten->sitting 最短编辑距离为："+editDistance("kitten","sitting"));
    }
    public static int editDistance(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }
        int[][] matrix = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0) {
                    matrix[i][j] = j;
                } else if (j == 0) {
                    matrix[i][j] = i;
                } else {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        matrix[i][j] = matrix[i - 1][j - 1];
                    } else {
                        matrix[i][j] = 1 + Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                    }
                }
            }
        }
        return matrix[a.length()][b.length()];
    }
}
