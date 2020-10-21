import java.util.Scanner;

//Q: Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity.
//Input : mat[4][4] = { {10, 20, 30, 40},
//                      {15, 25, 35, 45},
//                      {27, 29, 37, 48},
//                      {32, 33, 39, 50}};
//              x = 29
//Output : Found at (2, 1)
public class SearchKeyInMatrix {
    public static void searchInMatrix(int M, int N, int key, int[][] mat){
        int i = 0;
        int j = N-1;
        while (i<M && j>=0){
            if(mat[i][j] > key){
                j=j-1;
            }
            else if(mat[i][j] < key){
                i = i+1;
            }
            else {
                System.out.println("Found at : ("+i + ","+j+")");
                return;
            }
        }
        System.out.println("Not found");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] mat = new int[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int key = sc.nextInt();
        searchInMatrix(M, N, key, mat);
    }
}
