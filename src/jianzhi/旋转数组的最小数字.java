package jianzhi;

public class 旋转数组的最小数字 {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int first = 0, last = array.length - 1;
        while (first < last) {
            if (array[first] < array[last]) {
                return array[first];
            }
            int mid = first + ((last - first) / 2);
            if (array[mid] > array[last]) {
                first = mid + 1;
            } else if (array[mid] < array[last]) {
                last = mid;
            } else {
                last--;
            }
        }
        return array[first];
    }
}