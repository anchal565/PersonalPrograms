public class Try extends BaseClass{

    public static void main(String[] args) {
        Try obj = new Try();
        print();
        obj.show();
    }

    public static void print(){
        System.out.println("I am in print() of child class");
    }

    public void show(){
        System.out.println("I am in show() of child class");
    }
}

class BaseClass{
    public static void print(){
        System.out.println("I am in print() of base class");
    }
    public void show(){
        System.out.println("I am in non-static show() of base class");
    }
}

