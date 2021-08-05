package top200;

import java.util.*;

public class 数字字符串转化成IP地址 {

    /*回溯法插入'.'，每次可以插入到1个，2个或者3个字符后面，插入3次之后对得到的字符串进行验证*/
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        backTrack(s, 0, 3, list);
        return list;
    }

    //  index:本次插入的起始位置   cnt:剩余可插入'.'的次数
    public void backTrack(String s, int index, int cnt, ArrayList<String> list) {
        if (cnt == 0) {
            String[] strs = s.split("\\."); //'.'要转义
            if (strs.length < 4) {
                //保证插入得到4个子串，不会出现多个'.'相连的情况
                return;
            }
            for (String str : strs) {
                //排除有前导0的情况
                if (str.length() > 1 && str.charAt(0) == '0') {
                    return;
                }
                //排除不在范围的情况
                if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255) {
                    return;
                }
            }
            list.add(s);
            return;
        }
        //没插完就结束的情况
        if (index >= s.length()) {
            return;
        }
        int n = s.length();
        //插入到1个字符之后
        backTrack(s.substring(0, index + 1) + "." + s.substring(index + 1, n),
                index + 2, cnt - 1, list);
        //插入到2个字符之后
        if (index + 2 < n) {
            backTrack(s.substring(0, index + 2) + "." + s.substring(index + 2, n),
                    index + 3, cnt - 1, list);
        }
        //插入到3个字符之后
        if (index + 3 < n) {
            backTrack(s.substring(0, index + 3) + "." + s.substring(index + 3, n),
                    index + 4, cnt - 1, list);
        }
    }

}
