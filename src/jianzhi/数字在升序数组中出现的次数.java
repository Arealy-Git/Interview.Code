package jianzhi;

import java.util.Scanner;

public class 数字在升序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    //递归写法
    public int getFirstK(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > target) {
            return getFirstK(array, target, start, mid - 1);
        } else if (array[mid] < target) {
            return getFirstK(array, target, mid + 1, end);
        } else if (mid - 1 > 0 && array[mid - 1] == array[mid]) {
            return getFirstK(array, target, start, mid - 1);
        } else {
            return mid;
        }
    }

    //循环写法
    public int getLastK(int[] array, int target, int start, int end) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (array[mid] < target) {
                start = mid + 1;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else if (mid + 1 < array.length && array[mid + 1] == array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
