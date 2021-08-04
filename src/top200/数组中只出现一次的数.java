package top200;

public class 数组中只出现一次的数 {

    public int foundOnceNumber(int[] arr, int k) {
        // 每个二进制位求和，如果某个二进制位不能被k整除，那么只出现一次的那个数字在这个二进制位上为1。
        int[] binarySum = new int[32];
        for (int i = 0; i < 32; i++) {//求每个二进制位的和
            int sum = 0;
            for (int num : arr) {
                sum += (num >> i & 1);//依次右移num，同1相与，计算每一位上1的个数
            }
            binarySum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (binarySum[i] % k != 0) {
                res += 1 << i;//左移恢复
            }
        }
        return res;
    }

}
