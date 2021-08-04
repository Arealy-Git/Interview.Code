package leetcode;

import java.util.Arrays;

public class 寻找两个正序数组的中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);

        Arrays.sort(result);
        int middle = result.length / 2;

        if (result.length % 2 == 0) {
            return ((double)result[middle - 1] + (double)result[middle]) / 2;
        } else {
            return (double)result[middle];
        }
    }

}
