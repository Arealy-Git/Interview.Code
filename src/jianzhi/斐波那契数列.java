package jianzhi;

import java.util.Scanner;

public class 斐波那契数列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Fibonacci_1(n));
        System.out.println(Fibonacci_2(n));
    }

    public static int Fibonacci_1(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return Fibonacci_1(n - 2) + Fibonacci_1(n - 1);
        }
    }

    public static int Fibonacci_2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0, mid = 1, last = 0;
        for (int i = 1; i < n; i++) {
            last = pre + mid;
            pre = mid;
            mid = last;
        }
        return last;
    }
}
