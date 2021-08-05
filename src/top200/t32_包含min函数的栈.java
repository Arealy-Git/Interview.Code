package top200;

import java.util.*;

public class t32_包含min函数的栈 {

    Stack<Integer> normal = new Stack<>();
    Stack<Integer> minval = new Stack<>();

    public void push(int node) {
        normal.push(node);
        if (minval.isEmpty()) {
            minval.push(node);
        } else {
            if (node <= minval.peek()) {
                minval.push(node);
            } else {
                minval.push(minval.peek());
            }
        }
    }

    public void pop() {
        normal.pop();
        minval.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minval.peek();
    }

}
