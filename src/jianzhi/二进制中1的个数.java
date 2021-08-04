package jianzhi;

import java.util.Scanner;

public class 二进制中1的个数 {

    public static int NumberOf1_1(int n) {
        String result = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int NumberOf1_2(int n) {
        int count = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

}
