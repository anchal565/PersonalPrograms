import java.util.Scanner;
import java.util.Stack;
//You are given an array A of size N. Replace every element with the next greatest element (greatest element on its right side) in the array. Also, since there is no element next to the last element, replace it with -1.
public class NextGreaterElement {

    public void nextGreaterElement(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack();
        for(int i=n-1; i>=0; i--){
            int key = arr[i];
            if(stack.isEmpty()){
                arr[i] = -1;
                stack.push(key);
            }
            else {
                arr[i] = stack.peek();
            }
            if(!stack.isEmpty() && key > stack.peek()){
                stack.push(key);
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers in array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter numbers");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        nextGreaterElement.nextGreaterElement(arr);
    }
}
