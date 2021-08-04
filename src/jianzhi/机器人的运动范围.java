package jianzhi;

public class 机器人的运动范围 {

    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return findPath(0, 0, rows, cols, flag, threshold);
    }

    private int findPath(int row, int col, int rows, int cols, int[][] flag, int threshold) {
        if (row < 0 || col < 0
                || row >= rows || col >= cols
                || numSum(row) + numSum(col) > threshold
                || flag[row][col] == 1) {
            return 0;
        }
        flag[row][col] = 1;
        return 1
                + findPath(row - 1, col, rows, cols, flag, threshold)
                + findPath(row, col - 1, rows, cols, flag, threshold)
                + findPath(row + 1, col, rows, cols, flag, threshold)
                + findPath(row, col + 1, rows, cols, flag, threshold);
    }

    private int numSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
