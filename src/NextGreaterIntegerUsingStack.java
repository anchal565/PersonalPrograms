import java.util.Scanner;
import java.util.Stack;

public class NextGreaterIntegerUsingStack {
    public static void main(String[] ar){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int j=0;j<T;j++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            System.out.println();
            Stack<Integer> finalStack = new Stack<>();
            for (int i = N - 1; i >= 0; i--) {

                int key = A[i];
                if (finalStack.isEmpty())
                    A[i] = -1;
                else if (finalStack.size() > 0 && finalStack.peek() > A[i])
                    A[i] = finalStack.peek();
                else {
                    while (finalStack.size() > 0 && (finalStack.peek() < A[i])) {
                        finalStack.pop();
                    }
                    if (finalStack.isEmpty())
                        A[i] = -1;
                    else
                        A[i] = finalStack.peek();
                }

                finalStack.push(key);
            }
            //System.out.println("Array elements after modification are : ");
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();


        }
    }
}
