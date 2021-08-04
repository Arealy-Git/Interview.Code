package 整合.动态规划;

public class 矩阵的最小路径和 {
    public int minPathSum(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        //第一行
        for (int col = 1; col < matrix[0].length; col++) {
            dp[0][col] = matrix[0][col] + dp[0][col - 1];
        }
        //第一列
        for (int row = 1; row < matrix.length; row++) {
            dp[row][0] = matrix[row][0] + dp[row - 1][0];
        }
        //其他
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                dp[row][col] = matrix[row][col]
                        + Math.min(dp[row - 1][col], dp[row][col - 1]);
            }
        }

        return dp[matrix.length - 1][matrix[0].length - 1];
    }
}
