import java.util.Scanner;

public class SubarrayOfGivenSum {

    /*public static void subArrayIndex(int S, int[] arr, int N){
        int start = 0;
        int end = 0;
        int sum =arr[0];
        while(end<N && start<=end){
            if(sum < S){
                if(end != N-1) {
                    end++;
                    sum = sum + arr[end];
                }
                else {
                    System.out.println("-1");
                    return;
                }

            }
            else if(sum > S) {
                if(start == end)
                    end++;
                sum = sum - arr[start];
                start++;
            }
            if(sum == S) {
                System.out.print(start+1 +" "+ (end+1));
                return;
            }
        }
        System.out.println("-1");
    }*/

    public static void subArrayIndex(int S, int[] arr, int N){
        int index = 0;
        int sum = arr[0];
        //N equal to so that last element pe jane ke baad ek baar aur while loop chale to subtract from starting
        for(int i = 1; i<=N; i++){
            while(sum > S && index < i){
                sum = sum - arr[index];
                index++;
            }
            if(sum == S){
                System.out.println(index+1+" "+i);
                return;
            }
            //as N equal to tak loop hai toh N se pehle toh hi add kare
            if(i<N)
                sum = sum+arr[i];
        }
        if(sum != S)
            System.out.println("-1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int S = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = sc.nextInt();
            }
            subArrayIndex(S, A, N);

        }
    }
}
