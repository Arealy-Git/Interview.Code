package jianzhi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class 数组中只出现一次的两个数字 {

    public int[] FindNumsAppearOnce_2(int[] array) {
        int[] res = new int[2];
        if (array == null || array.length == 0) {
            return res;
        }

        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x ^= array[i];
        }

        int y = 1;
        while ((x & 1) != 1) {
            x >>= 1;
            y <<= 1;
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & y) == y) {
                res[0] ^= array[i];
            } else {
                res[1] ^= array[i];
            }
        }
        Arrays.sort(array);
        return res;
    }

    public int[] FindNumsAppearOnce_1(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        Set<Integer> keys = map.keySet();
        int[] res = new int[2];
        int index = 0;
        for (int i : keys) {
            if (map.get(i) == 1) {
                res[index++] = i;
            }
        }
        return res;
    }
}
