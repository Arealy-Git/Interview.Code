package jianzhi;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp;

        int first = 1, last = 2, total = 0;
        while (first < last) {
            total = (first + last) * (last - first + 1) / 2;
            if (total < sum) {
                last++;
            } else if (total > sum) {
                first++;
            } else {
                temp = new ArrayList<>();
                for (int i = first; i <= last; i++) {
                    temp.add(i);
                }
                result.add(temp);
                first++;
            }
        }
        return result;
    }
}
