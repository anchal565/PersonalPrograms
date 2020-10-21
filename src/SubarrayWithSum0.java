import java.util.HashMap;
import java.util.Scanner;

//Q: Find all subarrays in an array with sum as 0.
public class SubarrayWithSum0 {

    public static void subarrayWithSum0(int[] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int i=0;
        int sum =0;
        while (i<arr.length){
            sum += arr[i];
            if(hashMap.get(sum) == null)
                hashMap.put(sum, i);
            else {
                System.out.println("Yes");
                System.out.println(hashMap.get(sum)+1+" "+i);
                return;
                //System.out.println(hashMap.get(sum)+1+" "+i);
            }
            i++;
        }
        if(hashMap.get(0) != null) {
            System.out.println(0 + " " + hashMap.get(0));
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
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
        subarrayWithSum0(arr);
    }
}
