package jianzhi;

public class 剪绳子 {
    public int cutRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        int res;
        for (int i = 4; i <= n; i++) {
            res = 0;
            for (int j = 1; j <= (i / 2); j++) {
                res = Math.max(res, dp[i - j] * dp[j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
