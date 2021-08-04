package jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中的中位数 {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        } else {
            return (double) minHeap.peek();
        }
    }

}
