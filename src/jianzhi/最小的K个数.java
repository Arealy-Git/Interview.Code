package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {

    private ArrayList<Integer> GetLeastNumbers_Solution_2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        int length = input.length;
        if (k == 0 || k > length) {
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }

        return result;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution_1(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length) {
            return result;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }
    
}
