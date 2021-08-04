package jianzhi;

public class 跳台阶 {
    public static int jumpFloor_2(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return jumpFloor_2(n - 2) + jumpFloor_2(n - 1);
        }
    }

    public static int jumpFloor_1(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int pre = 1, mid = 2, last = 0;
        for (int i = 2; i < n; i++) {
            last = pre + mid;
            pre = mid;
            mid = last;
        }
        return last;
    }
}
