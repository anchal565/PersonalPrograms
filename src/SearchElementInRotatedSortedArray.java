//Find an element in a rotated array.
public class SearchElementInRotatedSortedArray {

    public int findPivot(int[] arr, int n){
        int start =0, end= n-1;
        while (end>start){
            int mid = (start+end)/2;
            if(arr[start] < arr[mid]){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return end;
    }

    public int searchKey(int[] arr, int pivot, int key){
        if(key == arr[pivot])
            return pivot;
        if(key < arr[0])
            return binarySearch(key, arr, pivot+1, arr.length-1);
        else
           return binarySearch(key, arr, 0, pivot-1);
    }

    public int binarySearch(int key, int[] arr, int start, int end){
        int mid = (start + end) / 2;
        if(key == arr[mid])
            return mid;
        if(end < start)
            return -1;
        if (key < arr[mid]) {
            return binarySearch(key, arr, start, mid-1);
        }
        else {
            return binarySearch(key, arr, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {30, 40, 50, 10, 20};
        SearchElementInRotatedSortedArray searchObj = new SearchElementInRotatedSortedArray();
        int n= arr.length;
        int pivot = searchObj.findPivot(arr,n);
        System.out.println("pivot is : "+pivot);
        int index = searchObj.searchKey(arr, pivot, 60);
        System.out.println("Index is : "+index);

    }
}
