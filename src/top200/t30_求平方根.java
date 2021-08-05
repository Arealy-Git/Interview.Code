package top200;

public class t30_求平方根 {

    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        int left = 1, right = x;
        while (true) {
            int middle = left + (right - left) / 2;
            if (middle <= x / middle && (middle + 1) > x / (middle + 1)) {
                return (int) middle;
            } else if (middle < x / middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    }

}
