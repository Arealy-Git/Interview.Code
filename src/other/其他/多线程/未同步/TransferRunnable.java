package other.其他.多线程.未同步;

class TransferRunnable implements Runnable {

    private Bank bank;
    private int fromAccount;
    private double maxAmount;//最大转帐金额
    private int DELAY = 10;

    public TransferRunnable(Bank b, int from, double max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run() {
        int toAccount = (int) (bank.size() * Math.random());
        double amount = maxAmount * Math.random();
        bank.transfer(fromAccount, toAccount, amount);
        try {
            Thread.sleep((int) (DELAY * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
