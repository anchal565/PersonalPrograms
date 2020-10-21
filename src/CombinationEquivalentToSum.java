import java.util.Scanner;

public class CombinationEquivalentToSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int l=1; l<=N; l++)
            recur(N, arr,0,l);
        //recur(N, arr, 1, 0, 0);

    }

    /*public static void recur(int N, int[] arr, int i, int index, int sum){
        if(index == N && sum!=N)
            return;
        if(i >= N+1 && sum !=N)
            return;
        if(sum == N){
            for(int j=0;j<N;j++)
                System.out.print(arr[j]+" ");
            return;
        }


        if(index == N && sum == N){
            for(int j=0;j<N;j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }

        for(int k=i; k<=N;k++) {
        recur(N, arr, i+1, index, sum);
            arr[index] = i;
            sum += i;

            recur(N, arr, k, index+1, sum);
        }
       // sum-=i;
    }*/


    public static void recur(int sum, int[]arr, int index, int i){
        if(index == arr.length)
            return;
        if(sum<0)
            return;
        if(sum == 0){
            for(int k=0; k<arr.length; k++)
                System.out.print(arr[k]+" ");
            System.out.println();
            return;
        }

        arr[index] = i;
        sum = sum-i;
        recur(sum, arr, index+1, i);
    }

}
