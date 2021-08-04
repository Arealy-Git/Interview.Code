package top200;

public class 子数组的最大累加和问题 {

    public int maxsumofSubarray(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
