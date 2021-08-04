package jianzhi;

public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
        }
        //下三角形
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                B[i] *= A[j];
            }
        }

        //上三角形
        for (int i = 1; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                B[i] *= A[j];
            }
        }
        return B;
    }
}
