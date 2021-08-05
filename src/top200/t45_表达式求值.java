package top200;

import java.util.*;

public class t45_表达式求值 {

    public int solve(String s) {
        //去除首尾空格
        s = s.trim();
        //字符串转化为字符串数组
        char[] arr = s.toCharArray();
        //定义一个堆栈,标识符，
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            //是否为空格
            if (ele == ' ') {
                continue;
            }
            //是否为数字
            if (Character.isDigit(ele)) {
                num = num * 10 + ele - '0';
            }
            //是否为(
            if (ele == '(') {
                //找到其)括号
                int numtmp = 1;//减到0时意味着遇到了对应的)
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        numtmp++;
                    } else if (s.charAt(j) == ')') {
                        numtmp--;
                    }
                    if (numtmp == 0) {
                        num = solve(s.substring(i + 1, j));
                        i = j;//注意:此处一定不可以写成i=j+1,因为整体的for循环，会在这个i的基础上再+1，就会直接越过)后面的那一个字符
                        break;
                    }
                }
            }
            //当+-*/时
            if (!Character.isDigit(ele) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-1 * num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = ele;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

}
