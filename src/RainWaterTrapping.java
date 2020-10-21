import java.util.Scanner;
import java.util.Stack;

public class RainWaterTrapping {

    static int quantity =0;
    public static void waterCount(int prev, Stack<Integer> stack){
        int width = 0;
        while(stack.peek() == 0){
            width = width+1;
            stack.pop();
        }
        int curr = stack.pop();
        while(stack.peek() == 0){
            width = width+1;
            stack.pop();
        }
        int next = stack.peek();
        //int diff = (Math.abs(stack.peek() - temp) * width);
        if(stack.peek() > prev && width >0){
            quantity = prev * width;
        }
        else
            quantity = stack.peek() * width;



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i<N;i++){
            stack.push(sc.nextInt());
        }

        int prev;
        while(stack.peek() ==0)
            stack.pop();
        prev = stack.pop();

    }


}
