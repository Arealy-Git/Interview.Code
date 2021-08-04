package other.排序算法;

public class 快速排序 {

    public void quickSort(int[] array, int start, int end) {
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
