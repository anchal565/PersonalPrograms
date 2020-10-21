public class PairOfSumGiven {
    public static void main(String[] arg){

        int[] arrOfSum=new int[]{11, 18, 13, 13, 8, 5};
        int n=4;

        int arr[] = new int[n];
        int bMinusA= arrOfSum[n-1] - arrOfSum[1];
        arr[1]=(bMinusA + arrOfSum[0])/2;
        arr[0]=arrOfSum[0] - arr[1];

        for(int i=2;i<n;i++){
            System.out.println("i : "+ i +" arr[i-1] : "+arr[i-1]);
            arr[i]= arrOfSum[i-1] - arr[0];
        }

        System.out.println("Array is : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
