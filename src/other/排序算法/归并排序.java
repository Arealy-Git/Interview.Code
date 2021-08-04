package other.排序算法;

// Merge Sort
public class 归并排序 {

    public int[] mergeSort(int[] array, int start, int end) {
        int[] temp = new int[array.length];
        divide(array, 0, array.length - 1, temp);
        return array;
    }

    private void divide(int[] array, int start, int end, int[] temp) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            divide(array, start, middle, temp);
            divide(array, middle + 1, end, temp);
            merge(array, start, middle, end, temp);
        }
    }

    private void merge(int[] array, int start, int middle, int end, int[] temp) {
        int left = start, right = middle + 1, index = 0;
        while (left <= middle && right <= end) {
            temp[index++] = array[left] <= array[right] ? array[left++] : array[right++];
        }
        while (left <= middle) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        index = 0;
        while (start <= end) {
            array[start++] = temp[index++];
        }
    }

}
