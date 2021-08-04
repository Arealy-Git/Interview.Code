package other.其他.多线程.同步;

class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    /*使用ReentrantLock锁来保持同步*/
    /*
    public void transfer(int from ,int to ,double amount){
		bankLock.lock();
		try{
			if(accounts[from] < amount){ //金额不够
				return;
			}
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d",amount,from,to);
			accounts[to] += amount;
			System.out.printf(" Total balance %10.2f%n",getTotalBalance());
		}finally{
			bankLock.unlock();
		}
	}
    */

    /*使用synchronized来实现同步*/
    /*
    public synchronized void transfer(int from ,int to ,double amount){
		if(accounts[from] < amount){ //金额不够
			return;
		}
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d",amount,from,to);
		accounts[to] += amount;
		System.out.printf(" Total balance %10.2f%n",getTotalBalance());
	}
    */


    // 转帐
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) { //金额不够
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total balance %10.2f%n", getTotalBalance());
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}
