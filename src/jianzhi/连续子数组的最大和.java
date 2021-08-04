package jianzhi;

public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        //  以i为结尾的最大连续子数组，所有连续子数组中和为最大的。
        int max = array[0], res = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
