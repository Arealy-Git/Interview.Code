package top200;

public class t55_最长公共子序列 {

    public String LCS(String s1, String s2) {
        if (s1 == "" || s2 == "" || s1 == null || s2 == null) return "-1";
        //dp[i][j] 截至第ij位 两串的最长公共子串长度  把int 换 String
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];
        //初始化：空串与跟任何串的lcs都是0
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = "";
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = "";
        }
        //转移方程：
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //有共同字符 长度+1  记住 这里s1 s2 字符串下标从0开始的！
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                }
                //没找到共同字符 各退一步 继承两者大的那个
                else dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        //即便两串不为空串 lcs仍可能因为没有公共字符而使得lcs=0 这时英国返回-1
        return dp[s1.length()][s2.length()] == "" ? "-1" : dp[s1.length()][s2.length()];
    }

}
