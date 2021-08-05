package top200;

public class t60_反转数字 {

    public int reverse(int x) {
        long cur = 0;
        int finalcur = 0;
        while (x != 0) {
            cur = cur * 10 + x % 10;
            x /= 10;
        }
        if (cur < Integer.MIN_VALUE || cur > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) cur;
        }
    }

}
