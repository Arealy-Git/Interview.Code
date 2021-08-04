package jianzhi;

import java.util.HashMap;

public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution_2(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int preValue = array[0], time = 1;
        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                preValue = array[i];
                time = 1;
            }
            if (preValue == array[i]) {
                time++;
            } else {
                time--;
            }
        }
        return preValue;
    }

    public int MoreThanHalfNum_Solution_1(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, target = 0;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                count += 1;
                map.put(array[i], count);
            }
            if (max < map.get(array[i])) {
                max = map.get(array[i]);
                target = array[i];
            }
        }
        return target;
    }

}
