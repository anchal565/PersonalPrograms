import java.util.Scanner;
import java.util.Stack;

public class NextLargerElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            for(int i=N-1; i>=0; i--){
                int key = A[i];
                if(stack.isEmpty()){
                    A[i] = -1;
                }
                else {
                    while (stack.size()>0 && stack.peek() < A[i]) {
                        stack.pop();
                    }
                    if(stack.isEmpty())
                        A[i] =-1;
                    else if (stack.peek() > A[i])
                        A[i] = stack.peek();
                }
                stack.push(key);

            }

            for(int i=0; i<N; i++){
                System.out.print(A[i] +" ");
            }
        }
    }
}
