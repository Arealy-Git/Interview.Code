package jianzhi;

import java.util.regex.Pattern;

public class 表示数值的字符串 {
    public boolean isNumeric(String str) {
        /*
        ^表示开头   $表示结尾   java中两个表示\\代表一个\
        *零次或多次匹配前面的字符或子表达式
        ?零次或一次匹配前面的字符或子表达式
        +一次或多次匹配前面的字符或子表达式
        []字符集，匹配包含的任一字符
        */
        String pattern = "[+-]?\\d*\\.?\\d+|[+-]?\\d*\\.?\\d+[eE][+-]?\\d+";
        return Pattern.matches(pattern, str);
    }

    public boolean isNumeric_2(String str) {
        try {
            Double ans = Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
