import java.util.Scanner;
import java.util.Stack;

//Write a program to print all the LEADERS in the array.
// An element is leader if it is greater than all the elements to its right side.
// And the rightmost element is always a leader. For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
public class LeadersInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1; i>=0; i--){
            if(stack.isEmpty())
                stack.push(arr[i]);
            else {
                if(stack.peek() <= arr[i])
                    stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }

}

