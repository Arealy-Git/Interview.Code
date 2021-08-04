package other.设计模式.生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Producer implements Runnable {
    //库存队列
    private BlockingQueue<String> stock;
    //生产、消费延迟
    private int timeOut;
    private String productName;

    public Producer(BlockingQueue<String> stock, int timeOut, String productName) {
        this.stock = stock;
        this.timeOut = timeOut;
        this.productName = productName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stock.put(productName);
                System.out.println("正在生产数据 " + productName + " --库存剩余：" + stock.size());
                TimeUnit.MILLISECONDS.sleep(timeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
