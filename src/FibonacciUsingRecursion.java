import java.util.Scanner;

public class FibonacciUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int n = sc.nextInt();
        int result = fib(n);
        System.out.println("Fibonacci output is : "+result);*/

        //dynamic approach
        int N=sc.nextInt();
        long[] arr = new long[N+2];
        arr[0] = 0;
        arr[1] = 1;
        for(int j=2;j<=N;j++){
            arr[j] = (arr[j-1] + arr[j-2])%1000000007;
        }
        System.out.println(arr[N]);

        optimisedFibonacci(N);
    }

    //optimised approach
    public static void optimisedFibonacci(int N){
        long a = 0L;
        long b = 1L;
        long c = 0;
        for(int i =2 ; i<= N; i++) {
            c = (a + b)%1000000007;
            a = b;
            b = c;
        }
        if(N == 0)
            System.out.println(a);
        else if (N==1)
            System.out.println(b);
        else {
            System.out.println(c);
        }
    }


    //recursive approach
    public static int fib(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
