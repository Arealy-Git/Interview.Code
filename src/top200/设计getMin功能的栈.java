package top200;

import java.util.ArrayList;
import java.util.Stack;

public class 设计getMin功能的栈 {
    public int[] getMinStack(int[][] op) {

        ArrayList<Integer> array = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> min = new Stack<>();
        for (int i = 0; i < op.length; i++) {
            if (op[i][0] == 1) {
                stack.push(op[i][1]);
                if (!min.isEmpty() && min.peek() >= op[i][1]) {
                    min.push(op[i][1]);
                }
                if (min.isEmpty()) {
                    min.push(op[i][1]);
                }
            } else if (op[i][0] == 2) {
                int num = stack.pop();
                if (min.peek().equals(num)) {
                    min.pop();
                }
            } else if (op[i][0] == 3) {
                array.add(min.peek());
            }
        }
        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = array.get(i);
        }
        return result;

    }
}
