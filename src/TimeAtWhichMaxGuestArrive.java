import java.util.Arrays;
import java.util.Scanner;

//Q: Consider a big party where a log register for guest’s entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
//Each test case contains an entry and exit array respectively.
//1 2 10 5 5
//4 5 12 9 12
public class TimeAtWhichMaxGuestArrive {
    public static void timeAtWhichMaxGuestPresent(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers in array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dep = new int[n];
        System.out.println("Enter numbers");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            dep[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0, j=0, guests_in=0, max_guest = Integer.MIN_VALUE, time=0;
        while (i<n && j<n){
            if(arr[i]<=dep[j]){
                guests_in++;
                if(max_guest < guests_in) {
                    max_guest = guests_in;
                    time = arr[i];
                }
                i++;
            }
            else {
                guests_in--;
                j++;
            }
        }
        System.out.println("Max guest present is : "+max_guest +" at time : "+time);
    }
}
