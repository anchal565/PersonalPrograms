import java.util.*;

//Count Triplets such that one of the numbers can be written as sum of the other two
public class CountTheTriplets {
    static HashMap<Integer, Integer> frequencyArr = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int count = 0;
            int[] arr = new int[N];
            ArrayList<Integer> uniqueArr = new ArrayList<>();
            for(int i=0; i<N;i++){
                 arr[i] = sc.nextInt();
                 if(frequencyArr.get(arr[i]) == null){
                     uniqueArr.add(arr[i]);
                     frequencyArr.put(arr[i], 1);

                 } else {
                     frequencyArr.put(arr[i], frequencyArr.get(arr[i])+1);
                 }
            }
            Collections.sort(uniqueArr);
            System.out.println("Sorted is : "+  uniqueArr);
            System.out.println(frequencyArr);


             for(int k=uniqueArr.size()-1 ; k>=1; k--){
                 int toCheck = arr[k];

                 count = count + checkSum(0, k-1, k,uniqueArr);
             }

            System.out.println("count is " + count);
        }
    }

    private static int checkSum(int a, int b , int c, ArrayList<Integer> arr){
        int count = 0;
        while(a<=b){
            if(arr.get(a) + arr.get(b) == arr.get(c)) {
                if (a==b && frequencyArr.get(arr.get(a)) > 1) {
                    count += frequencyArr.get(arr.get(c))  * getNC2Sum(frequencyArr.get(arr.get(a))) ;
                    a++;
                    b--;
                } else {
                    count += frequencyArr.get(arr.get(c)) * frequencyArr.get(arr.get(b)) * frequencyArr.get(arr.get(a));
                    a++;
                    b--;
                }
            }
            else if(arr.get(a) + arr.get(b) > arr.get(c)){
                b--;
            }
            else
                a++;
        }
        return count;

    }

    private static int getNC2Sum(int n) {
        int sum =1;
        for (int i=3; i<=n ; i++) {
            sum *= i;
        }
        return sum;
    }
 }
