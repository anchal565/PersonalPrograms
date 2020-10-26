import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {
    final int a ;
    final List<Integer> list;
    public int getA(){
        return a;
    }
    public List<Integer> getList(){
         return new ArrayList<>(list);
    }
    public ImmutableClass(int a, List b){
        this.a = a;
        this.list = new ArrayList<>(b);
    }
    private final void sum(int x, int y){
        System.out.println(x+y);
    }

    public static void main(String[] args) {
        List abc = new ArrayList();
        abc.add(1);
        abc.add(2);
        ImmutableClass obj1 = new ImmutableClass(10,abc);
        abc.add(3);
        List<Integer> printList = obj1.getList();
        for(Integer a: printList)
            System.out.println(a);
        //obj.sum(10,20);
    }
}
