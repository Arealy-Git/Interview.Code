package jianzhi;

import java.util.Scanner;

public class 矩形覆盖 {

    public static int rectCover_2(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        int pre = 1, mid = 2, last = 0;
        for (int i = 2; i < target; i++) {
            last = pre + mid;
            pre = mid;
            mid = last;
        }
        return last;
    }

    //  递归方法
    public static int rectCover_1(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        } else {
            return rectCover_1(target - 1) + rectCover_1(target - 2);
        }
    }

}
