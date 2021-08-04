package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 扑克牌顺子 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] numbers = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.valueOf(str[i]);
        }
        System.out.println(new 扑克牌顺子().IsContinuous_1(numbers));
    }

    public boolean IsContinuous_2(int[] numbers) {
        Arrays.sort(numbers);
        int numOfZero = 0, numOfInterval = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            numOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        if (numOfZero >= numOfInterval) {
            return true;
        }
        return false;
    }

    public boolean IsContinuous_1(int[] numbers) {
        Arrays.sort(numbers);
        int numOfZero = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
            } else {
                list.add(numbers[i]);
            }
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) + 1) {
                continue;
            } else if (numOfZero > 0) {
                numOfZero--;
                list.add(i, list.get(i - 1) + 1);
                i--;
            } else {
                return false;
            }
        }
        return true;
    }
}
