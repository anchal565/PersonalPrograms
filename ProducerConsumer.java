import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    static int index = -1;
    static List<Integer> list = new ArrayList<>(10);

    public void producer() throws InterruptedException {
        synchronized (this) {
            do{
                notify();
                if (index < 10) {
                    list.add(++index,index);
                } else {
                    wait();
                }
            }while (true);
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (this) {
            do {
                notify();
                if (index >= 0) {
                    System.out.println(list.get(index));
                    index--;
                } else {
                    wait();
                }
            } while (true);
        }
    }

    public static void main(String[] args) {
        ProducerConsumer lockObject = new ProducerConsumer();
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockObject.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockObject.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.setPriority(Thread.MAX_PRIORITY);
        consumerThread.setPriority(Thread.MIN_PRIORITY);
        producerThread.start();
        consumerThread.start();
    }

}
