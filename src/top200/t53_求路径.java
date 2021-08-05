package top200;

public class t53_求路径 {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = 1;
                } else if (i == 0) {
                    dp[j] = dp[j - 1];
                } else if (j == 0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }

        return dp[n - 1];
    }

}
