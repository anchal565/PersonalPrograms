import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
//false for even, true for odd
public class ConvertArrIntoZigZag {

    public static void zigZag(int[] A, int N){
        int i =0;
        boolean flag = false;
        while (i < N-1){
            if(flag == false && A[i] > A[i+1]){
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
                i++;
                flag = true;
            }
            else if(A[i] < A[i+1] && flag == true){
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
                i++;
                flag = false;
            }
            else{
                i++;
                flag = !flag;
            }
        }
        for(int j=0;j<N;j++)
            System.out.print(A[j] +" ");
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T>0){
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++)
                A[i] = sc.nextInt();
            zigZag(A, N);
            T--;
        }
    }
}
