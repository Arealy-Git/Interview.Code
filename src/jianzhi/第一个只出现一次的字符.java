package jianzhi;

import java.util.HashMap;

public class 第一个只出现一次的字符 {
    public int FirstNotRepeatingChar_1(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar_2(String str) {
        char[] chars = str.toCharArray();
        int[] numbers = new int[256];

        for (int i = 0; i < chars.length; i++) {
            numbers[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (numbers[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
