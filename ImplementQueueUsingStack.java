import java.util.Stack;

public class ImplementQueueUsingStack {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();


    public static void insert(int B){
        if(stack1.isEmpty()){
            stack1.push(B);
        }
        else {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            stack2.push(B);
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
        }
    }

    public static int remove(){
        if(stack1.isEmpty())
            return -1;
        else
        return stack1.pop();
    }

    public static void main(String[] args) {

     }
}
