package top200;

public class 在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);
        return result;
    }

    private int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int index = -1;
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                index = mid;
                if (leftOrRight) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return index;
    }

}
