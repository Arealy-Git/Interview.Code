package 整合.排序;

public class 归并 {
    public static class MergeSort {

        public static void main(String[] args) {
            int[] array = {1, 2, 4, 3, 2, 5};
            new MergeSort().mergeSort(array);
            for (int i : array) {
                System.out.print(i + " ");
            }
        }

        private void mergeSort(int[] array) {
            int[] temp = new int[array.length];
            divide(array, 0, array.length - 1, temp);
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
                temp[index++] = array[left] < array[right] ? array[left++] : array[right++];
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
}
