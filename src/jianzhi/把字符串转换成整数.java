package jianzhi;

public class 把字符串转换成整数 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int flag = 1, sum = 0;
        if (chars[0] == '-') {
            flag = -1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                continue;
            }
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }
            sum = sum * 10 + (chars[i] - '0');
        }
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
            return 0;
        }
        return flag * sum;
    }
    
}
