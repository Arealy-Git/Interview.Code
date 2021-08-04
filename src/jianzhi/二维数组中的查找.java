package jianzhi;

import java.util.Scanner;

public class 二维数组中的查找 {

    //  二分法遍历
    public boolean Find_1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    //  右下角开始遍历
    public boolean Find_2(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;

    }
}
