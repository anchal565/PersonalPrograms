import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class LeadersInAnArray {

    public static void findLeaders(int[] A, int N){
        int max = A[N-1];
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1; i>=0; i--){
            if(A[i] >= max) {
                max = A[i];
                stack.push(A[i]);
            }

        }
        while (!stack.isEmpty())
            System.out.print(stack.pop()+" ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //try {
            int T = Integer.parseInt(br.readLine());


            //int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(br.readLine());
                int[] A = new int[N];
                String line = br.readLine();
                String[] strs = line.trim().split("\\s+");
                for (int i = 0; i < N; i++)
                    A[i] = Integer.parseInt(strs[i]);
                findLeaders(A, N);
            }
            br.close();
        /*}
        catch (NumberFormatException e){

        }*/
    }
}
