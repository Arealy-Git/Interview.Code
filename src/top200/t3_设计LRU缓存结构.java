package top200;

import java.util.*;

public class t3_设计LRU缓存结构 {

    public int[] LRU(int[][] operators, int k) {
        LinkedHashMap<Integer, Integer> lruMap = new LinkedHashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList();

        for (int[] op : operators) {
            switch (op[0]) {
                case 1:
                    if (lruMap.size() >= k) {
                        lruMap.remove(lruMap.keySet().iterator().next());
                    }
                    lruMap.put(op[1], op[2]);
                    break;
                case 2:
                    if (lruMap.containsKey(op[1])) {
                        int value = lruMap.get(op[1]);
                        list.add(value);
                        lruMap.remove(op[1]);
                        lruMap.put(op[1], value);
                    } else {
                        list.add(-1);
                    }
                    break;
                default:
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
