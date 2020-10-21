import java.util.Arrays;
import java.util.Scanner;
//Q: Given an array of size n. All elements in range 1 to n are present in the array except 1 element AND apart from this, 1 element is repeating. Find the missing and repeating element.
public class FindRepeatingAndMissingNum {

    //In O(nlogn) using sorting
    public void findMissingAndRepeating(int[] arr){
        Arrays.sort(arr);
        int expectedSum =0, actualSum=0;
        for(int i=0; i<arr.length; i++){
            expectedSum+=i+1;
            actualSum = actualSum + arr[i];
            if (expectedSum != actualSum){
                System.out.println("Missing number is : "+(i+1));
                System.out.println("Repeating number is : "+arr[i]);
                break;
            }
        }
    }
    //In O(n) without using extra space
    public void findMissAndREpeat(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[Math.abs(Math.abs(arr[i]) -1)] >0)
                arr[Math.abs(arr[i] -1)] = -arr[Math.abs(arr[i] -1)];
            else
                System.out.println("Repeating element is :"+Math.abs(arr[i]));
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0)
                System.out.println("Missing element is : "+(i+1));
        }
    }
    public void findMissAndREpeat1(int[] arr){
        int repeatingNum = 0, missingNum=0;
        for(int i=0; i<arr.length; i++){
            if(arr[Math.abs(Math.abs(arr[i]) -1)] >0)
                arr[Math.abs(arr[i]) -1] = -arr[Math.abs(arr[i]) -1];
            else{
                //System.out.println("Repeating element is :"+Math.abs(arr[i]));
                repeatingNum=Math.abs(arr[i]);

            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                //System.out.println("Missing element is : "+(i+1));
                missingNum=(i+1);
            }
        }
        System.out.println("Repeating number is "+repeatingNum+" and smallest positive missing number is "+missingNum+".");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers in array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter numbers");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        FindRepeatingAndMissingNum repeatingAndMissingNum = new FindRepeatingAndMissingNum();
    //    repeatingAndMissingNum.findMissingAndRepeating(arr);
       // repeatingAndMissingNum.findMissAndREpeat(arr);
        repeatingAndMissingNum.findMissAndREpeat1(arr);
    }
}
