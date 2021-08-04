package top200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 最长无重复子数组 {

    public int maxLength(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                start = Math.max(start, map.get(arr[end]) + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(arr[end], end);
        }
        return max;
    }

}
