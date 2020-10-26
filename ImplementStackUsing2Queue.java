import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsing2Queue {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static void push(int a){
        if(q1.isEmpty()){
            q1.add(a);
        }
        else {
            q2.add(a);
            while (!q1.isEmpty())
                q2.add(q1.remove());
            while (!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }
    }

    public static  int pop(){
        if(q1.isEmpty())
            return -1;
        return q1.remove();
    }

    public static void main(String[] args) {


    }
}
