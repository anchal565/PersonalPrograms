import java.util.*;

//https://leetcode.com/problems/largest-number/
public class LargestNumberFormed {
    public static String largestNumber(int[] nums) {
        Vector<String> arr = new Vector<>();
        for(int i=0; i<nums.length; i++){
            arr.add(String.valueOf(nums[i]));
        }
        Vector<Integer> vec = new Vector<>();
        vec.add(1);
        String number = "";
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2) > 0 ? -1:1;
            }
        });
        /*Iterator<String> iterator = arr.iterator();
        while (iterator.hasNext()){
            number = number+iterator.next();
            //System.out.print(iterator.next()+" ");
        }*/
        for(int i=0; i< arr.size();i++){
            if(arr.get(i).equals("0")){
                number = "0";
                break;
            }
            else {
                number = number+ arr.get(i);
            }
        }
        return number;
    }
    public static void mergeSort(int[] nums, int start, int end){
        if(start<end) {
            int mid = (start+end)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(start, mid, end, nums);
        }
    }

    public static void merge(int l, int m, int r, int[] nums){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0; i<n1; i++){
            L[i] = nums[l+i];
        }
        for(int j=0; j<n2; j++){
            R[j] = nums[j+m+1];
        }
        int i=0, j=0, k=l, a=0, rem1 =0, rem2 = 0;
        while(i<n1 && j<n2){
            while(L[i] > 0 && L[i] < 10){

            }
            if(L[i] < R[j]){
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            nums[k] = L[i];
            i++;
            k++;
        }
        while (j<n2){
            nums[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,0};
        /*mergeSort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));*/
        String result = largestNumber(arr);
        System.out.println(result);
    }
}
