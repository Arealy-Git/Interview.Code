package jianzhi;

import java.util.Scanner;

public class 数值的整数次方 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        int exponent = sc.nextInt();
        System.out.println(Power_1(base, exponent));
        System.out.println(Power_2(base, exponent));
    }

    public static double Power_1(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static double Power_2(double base, int exponent) {
        double sum = base;
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            for (int i = 1; i < exponent; i++) {
                sum *= base;
            }
            return sum;
        } else {
            for (int i = 1; i < -exponent; i++) {
                sum *= base;
            }
            return (double) 1 / sum;
        }
    }
}
