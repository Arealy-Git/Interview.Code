package jianzhi;

import java.util.ArrayList;

public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }
        int first = 0, last = array.length - 1, total = 0;
        while (first < last) {
            total = array[first] + array[last];
            if (total < sum) {
                first++;
            } else if (total > sum) {
                last--;
            } else {
                result.add(array[first]);
                result.add(array[last]);
                return result;
            }
        }
        return result;
    }
}
