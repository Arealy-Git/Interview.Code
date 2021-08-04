package jianzhi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows_2(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return result;
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int count = 0;
        for (; count < size; count++) {
            maxQueue.offer(num[count]);
        }
        while (count < num.length) {
            result.add(maxQueue.peek());
            maxQueue.remove(num[count - size]);
            maxQueue.add(num[count]);
            count++;
        }
        result.add(maxQueue.peek());

        return result;
    }

    public ArrayList<Integer> maxInWindows_1(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return result;
        }
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }

}
