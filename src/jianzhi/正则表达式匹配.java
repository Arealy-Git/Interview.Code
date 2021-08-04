package jianzhi;

public class 正则表达式匹配 {
    public boolean match(String str, String pattern) {
        //边界控制
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        //一对一匹配，或者有'.'
        boolean judge = (str.length() > 0 && pattern.length() > 0)
                && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

        //有*
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            //0个或多个
            return match(str, pattern.substring(2)) || (judge && match(str.substring(1), pattern));
        }
        //无*
        else {
            return judge && match(str.substring(1), pattern.substring(1));
        }
    }
}
