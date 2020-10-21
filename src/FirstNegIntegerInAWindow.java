import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Q: Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.
//
//Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
//Output : -8 0 -6 -6
//Input : arr[] = {-8, -2, 3, -6, 10}, k = 3
//Output : -8 -2 -6
public class FirstNegIntegerInAWindow {
    public void findNegNo(int[] arr, int k){
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        //int neg = 0;
        for(int i=0; i<arr.length; i++){
            int key = arr[i];

            queue1.add(key);
            if(key<0){
                queue2.add(key);
            }
            if(queue1.size() == k) {
                if (!queue2.isEmpty()){
                    System.out.print(queue2.peek() + " ");
                    if (queue1.peek() == queue2.peek()) {
                        queue2.poll();
                    }
                    queue1.poll();
                }
                else {
                    System.out.print("0 ");
                    queue1.poll();
                }
            }


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
        System.out.println("Enter size of a window");
        int k = sc.nextInt();
        FirstNegIntegerInAWindow negIntegerInAWindow = new FirstNegIntegerInAWindow();
        negIntegerInAWindow.findNegNo(arr, k);
    }
}
