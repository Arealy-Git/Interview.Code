package top200;

public class t29_最长递增子序列 {

    /*
    二分法：（注意这里dp的理解）
    end数组记录的是arr的每个数字对应的最长递增序列长度，
    dp数组下标i对应的是最长序列长度len(即i==len)，
    下标i的值对应的是以该字符结尾的最长递增子序列的结尾为dp[i],
    */

    public static int[] LIS(int[] arr) {
        int[] end = new int[arr.length];
        int[] dp = new int[arr.length];
        end[0] = 1;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = binarySearchInsertPosition(dp, len, arr[i]);
            dp[left] = arr[i];
            if (left == len) {
                len++;
            }
            end[i] = left;
        }
        len = len - 1;
        int res[] = new int[len + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (end[i] == len) {
                res[len--] = arr[i];
            }
        }
        return res;
    }

    private static int binarySearchInsertPosition(int arr[], int len, int val) {
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
