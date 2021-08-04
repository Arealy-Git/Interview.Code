package jianzhi;

import java.util.*;

public class 调整数组顺序使奇数位于偶数前面 {
    public static int[] reOrderArray_2(int[] array) {
        int nthOdd = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                nthOdd++;
                int curOdd = array[i];
                for (int j = i; j > nthOdd; j--) {
                    array[j] = array[j - 1];
                }
                array[nthOdd] = curOdd;
            }
        }
        return array;
    }

    public static int[] reOrderArray_1(int[] array) {
        if (array.length == 0) {
            return array;
        }
        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> even = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                odd.add(array[i]);
            } else {
                even.add(array[i]);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (!even.isEmpty()) {
                array[i] = even.poll();
            } else {
                array[i] = odd.poll();
            }
        }

        return array;
    }
}
