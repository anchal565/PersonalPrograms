public class MultiThreadForOddEven {
    public void printEven() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i <= 20; i = i + 2) {
                notify();
                System.out.println(i);
                wait();
            }
        }
    }
    public void printOdd() throws InterruptedException {
        synchronized (this) {
            for (int i = 1; i <= 20; i = i + 2) {
                notify();
                System.out.println(i);
                wait();
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        MultiThreadForOddEven lockObject = new MultiThreadForOddEven();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    lockObject.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    lockObject.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();

    }
}
