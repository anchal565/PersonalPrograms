//Given a number N, let the reverse of the number be R. The task is to print the output of the Expression pow(N,R),
// where pow function represents N raised to power R.
//Note: As answers can be very large, print the result modulo 1000000007
import java.util.Scanner;

public class ReverseDigitsOfNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long R = reverseOfNumber(N);
        long modulus = modulo(N, R, 1000000007);
        System.out.println(modulus);
        boolean checkForEven = checkIfEven(R);



    }



    public static long moduloFunct(long N, long R, long moduloInt ){
        long res = (long)(Math.pow(N,R)) % moduloInt;
        return res;

    }

    public static boolean checkIfEven(long N){
        if(N%2 == 0)
            return true;
        else
            return false;
    }

    public static long modulo(long N, long R, long moduloInt ){
        long check = R;
        long result =1 ;
        while(check > 0){
            result = (result * N ) % moduloInt;
            check--;
        }

        return result;
        //System.out.println("Result is : "+result);
    }

    public static long reverseOfNumber(long N){
        int rem =0;
        int i =1;
        int length = countLengthOfInteger(N);
        while(N>0){
            rem = (int)(rem + (Math.pow(10,length-i)) * (N%10));
            N=N/10;
            i++;
        }
        N = rem;
        return N;
        //System.out.println("Reverse is : "+N);
    }

    public static int countLengthOfInteger(long N){
        int count = 0;
        while(N>0){
            count++;
            N=N/10;
        }
        System.out.println("Length is : "+count);
        return count;
    }
}
