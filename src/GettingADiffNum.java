import java.util.Scanner;

//Given an array arr of unique nonnegative integers, implement a function getDifferentNumber
// that finds the smallest nonnegative integer that is NOT in the array.
public class GettingADiffNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = getDifferentNumber(arr);
        System.out.println("Result is : "+result);
    }

    static int getDifferentNumber(int[] arr) {

        for(int i =0;i<arr.length;i++) {
            int check = 0;
            for(int j=0;j<arr.length;j++){
                if(check == arr[j]){

                }
            }
        }
        return 0;
    }

    /*static int getDifferentNumber(int[] arr) {
        // your code goes here

        //int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];

        }
        System.out.println("Max is : " + max);
        int num = 0;
        while (num <= max) {
            for (int i = 0; i < arr.length; i++) {
                if (num == arr[i]) {
                    num = num + 1;
                    continue;
                }
                if (num == max) {
                    num = max + 1;
                    return num;
                }

            }
            return num;
        }
        if(num == max)
            num=num+1;
    }*/
}
