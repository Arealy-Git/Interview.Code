package 整合.动态规划;

public class 最长公共子序列 {

    public String LCS(String s1, String s2) {

        String[][] dp = new String[s1.length() + 1][s2.length() + 1];//表示当处理到s1的第i个元素和s2的第j个元素时公共子序列的长度

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = "";
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {//如果相同的话
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()] == "" ? "-1" : dp[s1.length()][s2.length()];
    }

}
