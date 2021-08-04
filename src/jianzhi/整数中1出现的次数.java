package jianzhi;

import java.util.Scanner;

public class 整数中1出现的次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new 整数中1出现的次数().NumberOf1Between1AndN_Solution(n));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += checkNumOf1(i);
        }
        return sum;
    }

    public int checkNumOf1(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
