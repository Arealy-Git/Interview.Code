package 整合.排序;

public class 快排 {
    public static class QuickSort {

        public static void main(String[] args) {
            int[] array = {1, 2, 4, 3, 2, 5};
            new QuickSort().quickSort(array, 0, array.length - 1);
            for (int i : array) {
                System.out.print(i + " ");
            }
        }

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
}
