package other.其他.多线程.同步;

public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;//帐户数
    public static final double INITIAL_BALANCE = 1000;//初始金额

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
