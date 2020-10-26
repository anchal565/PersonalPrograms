public class MultiThreadingUsingSynchronized {
    //SYNCHRINIZED BLOCK
    static Object ibject = new Object();
    public void show(){

        synchronized (ibject){
        for (int i=0;i<5;i++)
            System.out.println("Hii   " + Thread.currentThread().getName() + " " + i);

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->{
            Thread.currentThread().setName("111");
            new MultiThreadingUsingSynchronized().show();});

        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("222");
            new MultiThreadingUsingSynchronized().show();
        });
        thread1.setName("ONE");
        thread2.setName("TWO");
        thread1.start();
        thread2.start();
    }
}

