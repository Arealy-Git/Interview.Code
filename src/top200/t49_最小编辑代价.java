package top200;

public class t49_最小编辑代价 {

    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 == 0) {
            return n2 * ic;
        }
        if (n2 == 0) {
            return n1 * dc;
        }
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1; i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 0; i < n2; i++) {
            dp[0][i] = i * ic;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + dc, Math.min(dp[i][j - 1] + ic, dp[i - 1][j - 1] + rc));
                }
            }
        }
        return dp[n1][n2];
    }

}
