//this is using 2 stacks. With using single stack, 2*x - minElement from editorial.
import java.util.Stack;

public class GetMinimumElementFromStack {

    static int minEle;
    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static int getMin(){
        if(s2.isEmpty())
            return -1;
        else
            return s2.peek();
    }

    public static int pop(){
        int element = 0;
        if(s.isEmpty())
            return -1;
        if(s.peek() == s2.peek()){
            element = s.pop();
            s2.pop();
            return element;
        }
        else {
            element = s.pop();
            return element;
        }
    }

    public static void push(int x){
        if(s.isEmpty()){
            s.push(x);
            s2.push(x);
            minEle = s2.peek();
            return;
        }
        else {
            if(s2.peek() >= x){
                s2.push(x);
            }
        }
        s.push(x);

    }

    public static void main(String[] args) {

        pop();
        push(16);
        int min = getMin();
        System.out.println("Min : "+min);
        push(3);
        min = getMin();
        System.out.println("Min : "+min);
        push(3);
        pop();
        min = getMin();
        System.out.println("Min : "+min);
        push(1);
        min = getMin();
        System.out.println("Min : "+min);
        /*for(int i=0;i<s.size();i++)
            System.out.print(s.get(i)+" ");*/

    }
}
