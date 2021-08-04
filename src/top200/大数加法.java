package top200;

public class 大数加法 {

    public String solve(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int sl = s.length() - 1, tl = t.length() - 1, carry = 0;
        while (sl >= 0 || tl >= 0 || carry != 0) {
            int num1 = sl < 0 ? 0 : s.charAt(sl--) - '0';
            int num2 = tl < 0 ? 0 : t.charAt(tl--) - '0';
            int sum = num1 + num2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

}
