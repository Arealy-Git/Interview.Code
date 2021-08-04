package top200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (k == 0 || k > input.length) {
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }

        for (int num : maxHeap) {
            result.add(num);
        }

        return result;

    }
}
