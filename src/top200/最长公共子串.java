package top200;

public class 最长公共子串 {

    public String LCS(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        int max = 0, index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (max < dp[i + 1][j + 1]) {
                        max = dp[i + 1][j + 1];
                        index = i + 1;
                    }
                }
            }
        }
        return max == 0 ? "-1" : str1.substring(index - max, index);
    }

}
