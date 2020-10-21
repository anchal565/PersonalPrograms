import java.util.Arrays;
import java.util.Scanner;

//Q: Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct.
//
//input: arr[] = {7, 10, 4, 3, 20, 15}
//k = 3
//Output: 7
public class KthSmallestElementInArray {
    static int size;

    public static void createMin(int[] arr){
        for(int i=size/2 -1; i>=0; i--){
            minHeapify(i, arr);
        }
    }

    public static  void minHeapify(int pos, int[] arr){
        if(!isLeaf(pos)){
            int smallest = pos;
            if(leftChild(pos) < size && arr[pos] > arr[leftChild(pos)])
                smallest = leftChild(pos);
            if(rightChild(pos) < size && arr[smallest] > arr[rightChild(pos)])
                smallest = rightChild(pos);
            if(smallest != pos){
                swap(pos, smallest, arr);
                minHeapify(smallest, arr);
            }
        }
    }

    public static int leftChild(int pos){
        return 2*pos + 1;
    }

    public static int rightChild(int pos){
        return 2*pos + 2;
    }
    public static boolean isLeaf(int pos){
        return (pos >= size/2 && pos <size);
    }
    public static void swap(int pos1, int pos2, int[] arr){
        int temp =arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static int extractMin(int[] arr){
        int key = arr[0];
        if(size>1)
            arr[0] = arr[size-1];
        size = size-1;
        minHeapify(0, arr);
        return key;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        size = N;
        int K = sc.nextInt();
        //System.out.println("K is : "+K);
        createMin(arr);
        //System.out.println("Tree craeted is : "+Arrays.toString(arr));
        for (int i=0; i<K-1; i++){
            extractMin(arr);
        }
        System.out.println("Kth minimum is : "+arr[0]);


    }
}
