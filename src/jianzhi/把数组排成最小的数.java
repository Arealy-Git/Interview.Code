package jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 把数组排成最小的数 {

    public String PrintMinNumber_2(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        String result = "";
        for (Integer integer : numbers) {
            result += integer;
        }
        return result;
    }

    public String PrintMinNumber_1(int[] numbers) {
        ArrayList<String> resultList = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = numbers[i] + "";
        }

        Fun(strs, resultList, 0);

        Collections.sort(resultList);

        return resultList.get(0);
    }

    public void Fun(String[] strs, ArrayList<String> list, int i) {
        if (i == strs.length - 1) {
            if (!list.contains(getString(strs))) {
                list.add(getString(strs));
            }
        } else {
            for (int j = i; j < strs.length; j++) {
                swap(strs, i, j);
                Fun(strs, list, i + 1);
                swap(strs, j, i);
            }
        }
    }

    public void swap(String[] strs, int i, int j) {
        String t = strs[i];
        strs[i] = strs[j];
        strs[j] = t;
    }

    public String getString(String[] strs) {
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            result += strs[i];
        }
        return result;
    }

}
