package jianzhi;

public class 求1_2_3__n {

    public static void main(String[] args) {
        System.out.println(new 求1_2_3__n().Sum_Solution_1(5));
    }

    public int Sum_Solution_1(int n) {
        return n == 1 ? 1 : (n + Sum_Solution_1(n - 1));
    }

    public int Sum_Solution_2(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    public int Sum_Solution_3(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution_3(n - 1)) > 0);
        return sum;
    }
}
