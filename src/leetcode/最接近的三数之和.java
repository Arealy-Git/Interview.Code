package leetcode;

import java.util.Arrays;

public class 最接近的三数之和 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, len = nums.length, ans = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = len - 1;
            while (start < end) {
                int value = nums[i] + nums[start] + nums[end];
                if (value == target) {
                    return value;
                }
                if (Math.abs(value - target) < min) {
                    min = Math.abs(value - target);
                    ans = value;
                }
                if (value > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ans;
    }

}
