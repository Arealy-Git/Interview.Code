package top200;

public class 寻找第K大 {

    public int findKth(int[] a, int n, int K) {
        quickSort(a, 0, n - 1);
        return a[n - K];
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int left = start, right = end, pivot = array[start];
            while (left < right) {
                while (left < right && array[right] > pivot) {
                    right--;
                }
                if (left < right) {
                    array[left++] = array[right];
                }
                while (left < right && array[left] < pivot) {
                    left++;
                }
                if (left < right) {
                    array[right--] = array[left];
                }
            }
            array[left] = pivot;
            quickSort(array, start, left - 1);
            quickSort(array, left + 1, end);
        }
    }

}
