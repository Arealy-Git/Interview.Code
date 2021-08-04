package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        /*哈希集合，记录每个字符是否出现过*/
        Set<Character> occ = new HashSet<>();
        /*右指针，初始值为-1，相当于字符串左边界的左侧，还没有开始移动*/
        int rk = -1, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                /*左指针向右移动一格，移除一个字符*/
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                /*不断移动右指针*/
                rk++;
            }
            /*第i到rk个字符，是一个极长的无重复字符串子串*/
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
