package top200;

import base.Interval;

import java.util.*;

public class t54_合并区间 {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            return res;
        }
        //先对start排序
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        //结果中先放一个Interval
        res.add(intervals.get(0));
        int i = 0;
        //将intervals中每一个的start与res的end比较，res.end>=intervals.start就更新，否则直接添加
        for (i = 1; i < intervals.size(); i++) {
            int left = intervals.get(i).start;
            int right = intervals.get(i).end;
            if (res.get(res.size() - 1).end < left) {
                res.add(new Interval(left, right));
            } else {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, right);
            }
        }
        return res;
    }

}
