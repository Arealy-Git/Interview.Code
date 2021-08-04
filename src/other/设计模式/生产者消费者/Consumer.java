package other.设计模式.生产者消费者;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    //库存队列
    private BlockingQueue<String> stock;
    private String consumerName;

    public Consumer(BlockingQueue<String> stock, String consumerName) {
        this.stock = stock;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //从库存消费一台电脑
                String takeName = stock.take();
                System.out.println(consumerName + " 正在消费数据：" + takeName + " --库存剩余：" + stock.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
