import java.util.Arrays;

public class MergeSort {
    public static void merge(int l, int r, int mid, int[] arr){
        int n1= mid-l+1;
        int n2 = r-mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0; i<n1; i++)
            L[i] = arr[l+i];
        for(int j=0; j<n2; j++)
            R[j] = arr[mid+1+j];
        int i=0, j=0, k=l;
        while (i<n1 && j<n2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int l,int r,int[] arr){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(l,mid, arr);
            mergeSort(mid+1, r, arr);
            merge(l,r,mid, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,6,9,12};
        mergeSort(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }
}
