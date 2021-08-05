package top200;

public class t47_进制转换 {

    public String solve(int M, int N) {
        if (M == 0) {
            return "0";
        }
        char[] nums = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        boolean flag = (M < 0);
        M = Math.abs(M);
        while (M > 0) {
            sb.append(nums[M % N]);
            M /= N;
        }
        String res = sb.reverse().toString();
        return flag ? "-" + res : res;
    }

}
