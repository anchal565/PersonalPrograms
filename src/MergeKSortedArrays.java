import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MinHeapNode{
    int value;
    int i;
    int j;
    MinHeapNode(int value, int i, int j){
        this.value = value;
        this.i = i;
        this.j = j;
    }
}
public class MergeKSortedArrays {

    public static ArrayList<Integer> mergeSortedArrays(int[][] arrays, int k){
        ArrayList<Integer> mergedList = new ArrayList<>();
        MinHeapNode[] heap = new MinHeapNode[k];
        for(int i=0; i<k ;i++){
            MinHeapNode node = new MinHeapNode(arrays[i][0], i, 0);
            heap[i] = node;
        }
        for(int a=k/2 -1; a>=0; a--){
            heapify(heap, a);
        }

        for(int a=k*k ; a>0;a--) {
            /*for (int z = k / 2 - 1; z >= 0; z--) {
                heapify(heap, z, mergedList);
            }*/
            //heapify(heap, k/2 -1, mergedList);
                //extract root and add to mergeList and add its successor
            heapify(heap, 0);
            mergedList.add(heap[0].value);
            if(heap[0].j +1 <k)
                heap[0].value = arrays[heap[0].i][(heap[0].j) + 1];
            else
                heap[0].value = Integer.MAX_VALUE;
            heap[0].i = heap[0].i;
            heap[0].j = heap[0].j + 1;
        }
        return mergedList;
    }

    public static void heapify(MinHeapNode[] heap, int i){
        if(!isLeaf(i, heap.length)) {
            int smallest = i;
            if (leftChild(i) > 0 && leftChild(i) < heap.length && heap[leftChild(i)].value < heap[smallest].value)
                smallest = leftChild(i);
            if (rightChild(i) > 0 && rightChild(i) < heap.length && heap[rightChild(i)].value < heap[smallest].value)
                smallest = rightChild(i);
            swap(heap, i, smallest);
            if(smallest != i)
                heapify(heap, smallest);
        }
    }
    public static boolean isLeaf(int i, int K){
        if(i>=0 && i<K/2)
            return false;
        else
            return true;
    }
    public static int leftChild(int i){
        return 2*i+1;
    }
    public static int rightChild(int i){
        return 2*i+2;
    }
    public static void swap(MinHeapNode[] arrays, int value1, int value2){
        MinHeapNode temp = arrays[value1];
        arrays[value1] = arrays[value2];
        arrays[value2] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[][] matrix = new int[K][K];
        for(int i=0; i<K; i++){
            for(int j=0; j<K; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> mergedList = mergeSortedArrays(matrix, K);
        for(Integer values : mergedList){
            System.out.print(values + " ");
        }
    }
}
