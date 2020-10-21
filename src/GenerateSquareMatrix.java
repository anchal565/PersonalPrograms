//Given a +ve integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
//Input : 3
//Output :
//[1    2   3],
//[8    9   4],
//[7    6   5]
import java.util.Scanner;

public class GenerateSquareMatrix {
    public static void generateMatrix(int N){
        int[][] matrix = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visited[i][j] = false;
            }
        }
        int value = 1,counter=1;
        boolean direction = false;
        matrix[0][0] = value++;
        visited[0][0] = true;
        int i=0, j=0, k=1;
        while (value <= N*N) {
            /*if(value == (4*(N-k) +1)){
                direction = false;
                k = k+2;
            }*/
            //right
            if (direction == false && (j+1 < N) && visited[i][j + 1] == false) {
                matrix[i][j + 1] = value++;
                visited[i][j + 1] = true;
                j++;
            }
            //down
            else if (i + 1 < N && visited[i + 1][j] == false) {
                matrix[i + 1][j] = value++;
                visited[i + 1][j] = true;
                i++;
            }
            //left
            else if (j > 0 && visited[i][j - 1] == false) {
                matrix[i][j - 1] = value++;
                visited[i][j - 1] = true;
                j--;
            }
            //top
            else if (i > 0 && visited[i - 1][j] == false) {
                matrix[i - 1][j] = value++;
                visited[i - 1][j] = true;
                direction = true;
                i--;
            }
            else {
                direction = false;
            }
        }
       for(int r=0; r<N; r++){
           for(int s=0; s<N; s++){
               System.out.print(matrix[r][s]+" ");
           }
           System.out.println();
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        generateMatrix(N);
    }
}
