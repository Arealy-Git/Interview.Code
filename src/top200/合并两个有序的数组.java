package top200;

public class 合并两个有序的数组 {

    public void merge(int A[], int m, int B[], int n) {
        int[] result = new int[m + n];
        int index = 0, indexA = 0, indexB = 0;
        while (indexA < m && indexB < n) {
            result[index++] = A[indexA] < B[indexB] ? A[indexA++] : B[indexB++];
        }

        while (indexA < m) {
            result[index++] = A[indexA++];
        }
        while (indexB < n) {
            result[index++] = B[indexB++];
        }

        for (int i = 0; i < result.length; i++) {
            A[i] = result[i];
        }
    }

}
