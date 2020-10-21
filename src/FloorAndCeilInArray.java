import java.util.Scanner;

//Q: Find the floor and ceil of a given number in an array.
// int[] : {2,4,6,14,19} , num=3
//output : ceil : 4, floor:2
public class FloorAndCeilInArray {
    public static int findFloor(int[] arr, int num, int start, int end){
        if(start > end && end == arr.length-1)
            return arr[arr.length -1];
        if(start > end && start == 0)
            return -1;
        int mid = (start+end)/2;
        if(arr[mid] == num)
            return arr[mid];
        if(start<mid && arr[mid-1] < num && arr[mid] > num){
            return arr[mid-1];
        }
        if(mid<end && arr[mid] < num && arr[mid+1] > num){
            return arr[mid];
        }
        if(arr[mid] > num){
            return findFloor(arr,num, start, mid-1);
        }
        else {
            return findFloor(arr, num, mid+1, end);
        }
    }

    public static int findCeil(int[] arr, int num, int start, int end){
        if(start > end && end == arr.length-1)
            return -1;
        if(start > end && start == 0)
            return arr[0];
        int mid = (start+end)/2;
        if(arr[mid] == num)
            return arr[mid];
        if(start<mid && arr[mid-1] < num && arr[mid] > num){
            return arr[mid];
        }
        if(mid<end && arr[mid] < num && arr[mid+1] > num){
            return arr[mid+1];
        }
        if(arr[mid] > num){
            return findCeil(arr,num, start, mid-1);
        }
        else {
            return findCeil(arr, num, mid+1, end);
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
        int number = sc.nextInt();
        int floor = findFloor(arr, number, 0, n-1);
        System.out.println("Floor is : "+floor);
        int ceil = findCeil(arr, number, 0, n-1);
        System.out.println("Ceil is : "+ceil);
    }
}
