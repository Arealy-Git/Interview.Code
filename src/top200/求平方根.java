package top200;

public class 求平方根 {

    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int left = 1, right = x;
        while (left < right) {
            long middle = (left + right) / 2;
            if (middle * middle <= x && (middle + 1) * (middle + 1) > x) {
                return (int) middle;
            }
            if (middle * middle > x) {
                right = (int) middle;
            } else {
                left = (int) middle;
            }
        }
        return left;
    }

}
