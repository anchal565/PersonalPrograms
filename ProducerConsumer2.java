import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer2 {
    LinkedList<Integer> list = new LinkedList<>();
    int size = 2;
    public void producer() throws InterruptedException {
        Random random = new Random();
        while (true){
        synchronized (this) {
            if (list.size() > size)
                wait();
            list.add(random.nextInt());
            notify();
        }
        }
    }

    public void consumer() throws InterruptedException {
        //int i=0;
        while (true){
        synchronized (this) {
            if (list.size() == 0)
                wait();
            System.out.println(list.pop());
            notify();
        }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer2 obj = new ProducerConsumer2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}
