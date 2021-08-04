package other.设计模式.生产者消费者;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestMain {
    public static void main(String[] args) {

        //定义最大库存为10
        BlockingQueue<String> stock = new ArrayBlockingQueue<>(10);
        Thread p1 = new Thread(new Producer(stock, 500, "Mac"));
        Thread p2 = new Thread(new Producer(stock, 500, "Win"));
        Thread c1 = new Thread(new Consumer(stock, "c1"));
        Thread c2 = new Thread(new Consumer(stock, "c2"));

        p1.start();
        p2.start();
        c1.start();
        c2.start();

    }
}
