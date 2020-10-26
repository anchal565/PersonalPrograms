public class SingletonClass {
    private static SingletonClass obj = null;
    private static  Object lock = new Object();
    private SingletonClass(){
        System.out.println("Hiii I am a Singleton class");
    }
    public static synchronized SingletonClass getInstance(){
            if (obj == null)
                synchronized (lock) {
                    if (obj == null) {

                        obj = new SingletonClass();

                    }
                }

            return obj;

    }

    public static void main(String[] args) {
        SingletonClass obj = new SingletonClass();
    }
}
