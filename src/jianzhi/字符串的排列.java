package jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 字符串的排列 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> resultList = new ArrayList<>();
        if (str.length() == 0) {
            return resultList;
        }
        fun(str.toCharArray(), resultList, 0);
        Collections.sort(resultList);
        return resultList;
    }

    public void fun(char[] ch, ArrayList<String> list, int i) {
        if (i == ch.length - 1) {
            if (!list.contains(new String(ch))) {
                list.add(new String(ch));
            }
        } else {
            for (int j = i; j < ch.length; j++) {
                swap(ch, i, j);
                fun(ch, list, i + 1);
                swap(ch, j, i);
            }
        }
    }

    public void swap(char[] ch, int i, int j) {
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
    }

}
