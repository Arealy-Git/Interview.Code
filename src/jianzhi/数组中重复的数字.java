package jianzhi;

import java.util.HashMap;

public class 数组中重复的数字 {
    public int duplicate_1(int[] numbers) {
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (array[numbers[i]] != 0) {
                return numbers[i];
            }
            array[numbers[i]]++;
        }
        return -1;
    }

    public int duplicate_2(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            } else {
                return numbers[i];
            }
        }
        return -1;
    }
}
