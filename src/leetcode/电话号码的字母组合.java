package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {

    //  数字到号码的映射
    public String[] array = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //  路径
    public StringBuilder sb = new StringBuilder();

    //  结果集
    public List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0);
        return result;
    }

    //  回溯
    public void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String chars = array[digits.charAt(index) - '2'];
        for (char c : chars.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
