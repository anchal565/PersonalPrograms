import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/unsorted-array/0
public class ElementWithLeftSmallRightGreater {

    public static void element(int N, int[] A){
        if(N>2){
            int index = 1;
            int start =0;
            int end = N-1;
            while (index<N-1 && (start<index || index<end)){
                if(A[start] > A[index] || A[end]<A[index]) {
                    index++;
                    start = 0;
                    end = N-1;
                }
                else {
                    if (start != index) {
                        start++;
                    } if (end != index) {
                        end--;
                    }
                }
            }
            if(start == index && index == end){
                System.out.println(A[index]);
            }
            else if(index == N-1 && start != index)
                System.out.println("-1");
        }
        else
            System.out.println("-1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T>0){
            int N=sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++)
                A[i] = sc.nextInt();
            element(N, A);
            T--;
        }
    }
}
