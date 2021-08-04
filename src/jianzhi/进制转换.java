package jianzhi;

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + "的2进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的8进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的16进制是:" + Integer.toHexString(n));

        int radix = sc.nextInt();

        String ret = Integer.toString(n, radix);
        System.out.println(n + "的3进制是:" + ret);
        System.out.println(radix + "进制" + ret + "转10进制是:" + Integer.parseInt(ret, radix));
    }
}
