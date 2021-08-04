package jianzhi;

public class 数组中的逆序对 {
    int cnt = 0;

    public int InversePairs(int[] array) {
        if (array.length != 0) {
            divide(array, 0, array.length - 1);
        }
        return cnt;
    }

    public void divide(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;

        divide(array, start, mid);
        divide(array, mid + 1, end);

        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                cnt = (cnt + mid - i + 1) % 1000000007;
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            array[start + l] = temp[l];
        }
    }
}
