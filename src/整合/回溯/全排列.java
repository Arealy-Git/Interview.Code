package 整合.回溯;

import java.util.ArrayList;

public class 全排列 {

    public static void main(String[] args) {
        System.out.println(new 全排列().getAllList(new String[]{"123", "456", "789"}));
    }

    StringBuilder sb = new StringBuilder();

    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> getAllList(String[] array) {
        if (array == null || array.length == 0) {
            return result;
        }
        backtrack(array, 0);
        return result;
    }

    private void backtrack(String[] array, int index) {
        if (array.length == index) {
            result.add(sb.toString());
            return;
        }
        for (char c : array[index].toCharArray()) {
            sb.append(c);
            backtrack(array, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
