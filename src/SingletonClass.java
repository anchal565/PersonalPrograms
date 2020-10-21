public class SingletonClass {
    private SingletonClass(){
        System.out.println("HEYYY");
    }

    static SingletonClass obj;

    public static SingletonClass func(){
        if(obj == null)
        obj = new SingletonClass();

        return obj;
    }
}

class Second{
    public static void main(String[] args) {
        SingletonClass.func();
    }
}
