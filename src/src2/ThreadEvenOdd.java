public class ThreadEvenOdd {
    public void even(ThreadEvenOdd obj) throws InterruptedException {
        synchronized (obj) {
            for (int i = 0; i <= 10; i = i + 2) {
                notify();
                System.out.print(i);
                wait();
            }
        }
    }

    public void odd(ThreadEvenOdd obj) throws InterruptedException {
        synchronized (obj) {
            for (int i = 1; i <= 10; i = i + 2) {
                notify();
                System.out.print(i);
                wait();
            }
        }
    }

    public static void main(String[] args) {
        ThreadEvenOdd obj = new ThreadEvenOdd();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.even(obj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.odd(obj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
