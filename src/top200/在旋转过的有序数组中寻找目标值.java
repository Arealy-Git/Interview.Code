package top200;

public class 在旋转过的有序数组中寻找目标值 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左边有序
            if (nums[mid] >= nums[left]) {
                //target在左边
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //右边有序
            else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
