package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 圆圈中最后剩下的数 {

    public int LastRemaining_Solution_2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        Queue<Integer> orig = new LinkedList<>();
        Queue<Integer> help = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            orig.add(i);
        }

        while (orig.size() != 1) {
            for (int i = 0; i < m; i++) {
                if (i != (m - 1)) {
                    help.add(orig.poll());
                } else {
                    if (orig.size() != 0) {
                        orig.poll();
                    } else {
                        help.poll();
                    }
                }
            }
            while (help.size() > 0) {
                orig.add(help.poll());
            }
        }

        return orig.peek();
    }

    public int LastRemaining_Solution_1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int index = 0;
        while (circle.size() != 1) {
            index += (m - 1);
            index %= circle.size();
            circle.remove(index);
        }
        return circle.get(0);
    }
}
