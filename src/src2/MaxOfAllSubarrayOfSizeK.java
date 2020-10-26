import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxOfAllSubarrayOfSizeK {

    public static void maxOffAll(int[] arr, int K){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int i =0;

        while (i<arr.length) {
            queue.add(arr[i]);
            if(queue2.isEmpty())
                queue2.add(arr[i]);
            else if(queue2.peek() > arr[i])
                queue2.add(arr[i]);
            else{
                while (!queue2.isEmpty())
                    queue2.poll();
                queue2.add(arr[i]);
            }
            if (queue.size() == K) {
                System.out.print(queue2.peek() +" ");
                if(queue.peek() == queue2.peek())
                    queue2.poll();
                queue.poll();
            }
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t< T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i=0 ;i<N ;i++){
                arr[i] = sc.nextInt();
            }
            maxOffAll(arr, K);
        }
    }
}
