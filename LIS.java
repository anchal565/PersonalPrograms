import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        //int[] arr = new int[] {1,0,2,8,5,6,9,4,11};
        int[] arr = new int[] {10, 23, 2, 10, 17, 19, 15};
        int[] data = new int[arr.length];
        List<Integer> arrayList = new ArrayList<>();
        /*recur(arr,data,0,0);
        for (int i=0; i<data.length; i++)
            System.out.print(data[i] +" ");
        System.out.println();*/
        int result = recur(0, arr, -1, arrayList);
        System.out.println(result);
        /*for (Integer a: arrayList) {
            System.out.print(a + " ");
        }*/
        //System.out.println();
        //System.out.println();
        result = bottomUp(arr);
        System.out.println(result);
    }

    /*public static void recur(int[] arr, int[] data, int index, int i){
        if(index == arr.length)
            return;
        if(i == arr.length)
            return;
        recur(arr, data, index+1, i);
        if(i > 0 && data[i-1] < arr[index]) {
            data[i] = arr[index];
            recur(arr, data, index + 1, i + 1);
        }
    }*/

    public static int recur(int index, int[] arr, int lastElement, List<Integer> arrayList){
        boolean flag = false;
        if(index == arr.length)
            return 0;
        int l1= recur(index+1, arr, lastElement, arrayList);
        int l2=0;
        if(lastElement < arr[index]){
            //data[i] = arr[index];
            arrayList.add(arr[index]);
            flag = true;
             l2 = 1 + recur(index+1, arr, arr[index], arrayList);
             /*data[i] = -1;
             l2 = 1 - recur(index+1, arr, arr[index], data, i);*/
        }
        else {
            l2 = recur(index + 1, arr, lastElement, arrayList);
        }
        if(l1< l2) {
            l1 = l2;
            if(flag == true) {
                arrayList.add(arr[index]);
            }
        }
        return l1;


        //return Math.max(l1, l2);
    }

    public static int bottomUp(int[] arr){

        int[] lis = new int[arr.length];
        for(int i=0; i<lis.length; i++){
            lis[i] = 1;
        }
        for(int i=1; i<lis.length;i++){
            for (int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    lis[i] = Math.max(lis[j]+1, lis[i]);
                }
            }
        }
        System.out.println(Arrays.toString(lis));
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=lis.length-1 ;i>=0; i--){
            if(maxValue<lis[i]){
                maxValue = lis[i];
                maxIndex = i;
            }
        }
        int index = maxValue;
        for(int i=maxIndex; i>=0; i--){
            if(lis[i] == index) {
                System.out.print(arr[i] + " ");
                index--;
            }
        }
        System.out.println();
        return maxValue;
    }
}
