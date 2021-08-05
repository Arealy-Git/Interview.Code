package top200;

public class t36_接雨水问题 {

    public static long maxWater(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }
        int left = 0, right = arr.length - 1;
        long sum = 0;

        int mark = Math.min(arr[left], arr[right]);
        while (left < right) {
            if (arr[left] < arr[right]) {
                left++;
                if (arr[left] < mark) {
                    sum += mark - arr[left];
                } else {
                    mark = Math.min(arr[left], arr[right]);
                }
            } else {
                right--;
                if (arr[right] < mark) {
                    sum += mark - arr[right];
                } else {
                    mark = Math.min(arr[right], arr[left]);
                }
            }
        }
        return sum;
    }

}
