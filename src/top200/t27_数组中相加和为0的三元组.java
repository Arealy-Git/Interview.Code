package top200;

import java.util.*;

public class t27_数组中相加和为0的三元组 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null || num.length <= 2) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int left = i + 1, right = num.length - 1;
            while (left < right) {
                if (-num[i] == (num[left] + num[right])) {
                    result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[left], num[right])));
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                } else if (-num[i] > (num[left] + num[right])) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}
