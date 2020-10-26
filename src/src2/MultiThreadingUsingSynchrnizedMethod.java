public class MultiThreadingUsingSynchrnizedMethod {
    //SYNCHRONIZED METHOD
    public  synchronized void show(){
        for (int i=0; i<10; i++)
            System.out.println(Thread.currentThread().getName()+" "+i);
    }
    public static void main(String[] args) {
        final Object object = new Object();
        MultiThreadingUsingSynchrnizedMethod oneObject = new MultiThreadingUsingSynchrnizedMethod();

        Thread thread1 = new Thread(() ->{
            Thread.currentThread().setName("111");
            oneObject.show();});

        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("222");
            oneObject.show();
        });
        thread1.setName("ONE");
        thread2.setName("TWO");
        thread1.start();
        thread2.start();
    }
}
