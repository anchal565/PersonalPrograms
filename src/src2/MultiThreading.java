public class MultiThreading extends Thread {

    static Object object = new Object();
    public void run() {
        //synchronized (object) {
        /*try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
            for (int i = 1; i < 20; i=i+2) {
                System.out.println(i);
                Thread.yield();
            }
        //}

    }
}
class EvenThread extends Thread{
    public void run(){
        /*try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for(int i=2; i<=20;i=i+2) {
            System.out.println(i);

            Thread.yield();
        }
    }
}

class New{
    public static void main(String[] args) throws InterruptedException {
        MultiThreading thread1 = new MultiThreading();
        EvenThread thread2 = new EvenThread();
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        //thread1.join();
        //thread2.yield();
        thread2.start();
        //thread2.yield();
        /*MultiThreading thread2 = new MultiThreading();
        thread2.start();*/

    }
}
