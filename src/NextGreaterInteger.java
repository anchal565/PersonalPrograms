import java.util.Scanner;

public class NextGreaterInteger {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int x=0;x<T;x++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

        /*for(int i=0;i<n-1;i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    arr[i] = arr[j];
                    break;

                }
                if(j==n-1 && arr[i]>arr[j])
                    arr[i]=-1;
            }

        }
        arr[n-1]=-1;*/

            int i = 0;
            int j = 1;
            while (i < N - 1) {
                if (i == N - 1)
                    break;
                if (A[i] < A[j]) {
                    A[i] = A[j];
                    i++;
                    j = i + 1;
                } else if (j == N - 1 && A[i] > A[j]) {
                    A[i] = -1;
                    i++;
                    j = i + 1;
                } else
                    j++;

            }
            A[N - 1] = -1;

            for (int k = 0; k < N; k++) {
                System.out.print(A[k] + " ");
            }
            System.out.println();

        }
    }
}
