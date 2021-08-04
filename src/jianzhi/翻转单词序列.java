package jianzhi;

public class 翻转单词序列 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] words = str.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i != 0) {
                result += " ";
            }
        }
        return result;
    }
}
