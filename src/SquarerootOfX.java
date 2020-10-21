import java.util.Scanner;

public class SquarerootOfX {
    public static long squareRoot(long start, long end, long num){
        long mid = (start+end)/2;
        if(start > end)
            return mid;
        if(((mid * mid)-num) == 0){
            return mid;
        }
        if(((mid * mid)-num) > 0)
            return squareRoot(start,mid-1, num);
        else
            return squareRoot(mid+1, end, num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //int N = Integer.MAX_VALUE;
        long squareRoot = squareRoot(0,N,N);
        System.out.println("square root is : "+squareRoot);
    }
}
