package leetcode;

import java.util.Scanner;

public class 最长回文子串 {

    /*动态规划*/
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int begin = 0, maxLen = 1;
        /*1、状态定义：dp[i][j]表示s[i...j]是否是回文串*/

        /*2、初始化：单个字符均是回文子串*/
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        /*3、状态转移：先填左下角*/
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                /*头尾字符不相等，不是回文串*/
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                }
                /*头尾字符相等*/
                else {
                    /*去掉头尾后没有剩余字符，或者只剩余一个字符，是回文子串*/
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        /*状态转移*/
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                /*只有dp[i][j] == true成立，表示s[i...j]是否是回文串*/
                /*此时更新记录回文长度和起始位置*/
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        /*4、返回值*/
        return s.substring(begin, begin + maxLen);
    }
}
