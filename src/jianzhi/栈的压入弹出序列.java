package jianzhi;

import java.util.Stack;

public class 栈的压入弹出序列 {

    public static boolean IsPopOrder_1(int[] pushA, int[] popA) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = popA.length - 1; i >= 0; i--) {
            stack2.push(popA[i]);
        }

        for (int i = 0; i < pushA.length; i++) {
            stack1.push(pushA[i]);
            while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
                stack1.pop();
                stack2.pop();
            }
        }

        if (stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean IsPopOrder_2(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}
