package leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            num_set.add(nums[i]);
        }
        int max = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int curNum = num, count = 1;
                while (num_set.contains(curNum + 1)) {
                    curNum++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

}
