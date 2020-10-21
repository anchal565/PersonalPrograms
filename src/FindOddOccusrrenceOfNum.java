import java.util.Scanner;
//Q: Given an array of positive integers. All numbers occur an even number of times except one number which occurs an odd number of times. Find the number in O(n) time & constant space.
//Input : arr = {1, 2, 3, 2, 3, 1, 3}
//Output : 3

public class FindOddOccusrrenceOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N ; i++){
            arr[i] =sc.nextInt();
        }
        int xor =0;
        for(int i=0;i<N; i++){
            xor = xor ^ arr[i];
        }
        System.out.println("Odd occurrence is of number : "+xor);
    }
}
