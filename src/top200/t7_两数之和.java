package top200;

import java.util.*;

public class t7_两数之和 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]) && (i != map.get(target - numbers[i]))) {
                result[0] = i + 1;
                result[1] = map.get(target - numbers[i]) + 1;
                break;
            }
        }
        return result;
    }

}
