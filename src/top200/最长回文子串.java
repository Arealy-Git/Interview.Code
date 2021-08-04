package top200;

public class 最长回文子串 {

    public int getLongestPalindrome(String A, int n) {
        if (n <= 1) {
            return A.length();
        }
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left < right; left++) {
                if (A.charAt(left) != A.charAt(right)) {
                    continue;
                }
                if (left == right || right - left <= 2) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                }
            }
        }
        return maxLen;
    }

}
