import java.util.Arrays;
import java.util.Scanner;

//Find a triplet that equals a given sum.
public class TripletThatEqualsGivenSum {

    public void triplet(int[] arr, int sum){
        Arrays.sort(arr);
        int first = 0, second = 1, third = arr.length-1;
        while (first<arr.length-2){
            second = first+1;
            third = arr.length-1;
            while (third > second) {
                if(arr[first] + arr[second] + arr[third] == sum){
                    System.out.println(arr[first] +" "+ arr[second]+" "+arr[third]);
                    return;
                }
                else if (arr[first] + arr[second] + arr[third] > sum)
                    third = third - 1;
                else {
                    second = second+1;
                }
            }
            first++;
        }
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
        TripletThatEqualsGivenSum triplet = new TripletThatEqualsGivenSum();
        triplet.triplet(arr, 10);
    }

}
