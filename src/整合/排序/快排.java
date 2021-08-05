package 整合.排序;

public class 快排 {

    public void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int left = start, right = end, pivot = array[left];
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
