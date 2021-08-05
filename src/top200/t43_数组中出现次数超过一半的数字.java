package top200;

public class t43_数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int preValue = array[0], time = 1;
        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                preValue = array[i];
                time = 1;
            }
            if (preValue == array[i]) {
                time++;
            } else {
                time--;
            }
        }
        return preValue;
    }

}
