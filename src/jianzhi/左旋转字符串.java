package jianzhi;

public class 左旋转字符串 {
    public String LeftRotateString_1(String str, int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.substring(n, str.length() - 1) + str.substring(0, n);
    }

    public String LeftRotateString_2(String str, int n) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        n = n % len;
        str += str;
        return str.substring(n, n + len);
    }
}
