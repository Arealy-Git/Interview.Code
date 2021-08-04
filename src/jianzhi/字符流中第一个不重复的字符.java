package jianzhi;

import java.util.ArrayList;
import java.util.HashMap;

public class 字符流中第一个不重复的字符 {
    String str = "";
    int[] asci = new int[256];

    public void Insert_1(char ch) {
        str += ch;
        asci[ch]++;
    }

    public char FirstAppearingOnce_1() {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (asci[c] == 1) {
                return c;
            }
        }
        return '#';
    }

    ArrayList<Character> list = new ArrayList<>();
    HashMap<Character, Integer> map = new HashMap<>();

    public void Insert_2(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    public char FirstAppearingOnce_2() {
        for (char c : list) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}
