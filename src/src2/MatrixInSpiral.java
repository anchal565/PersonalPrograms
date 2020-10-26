import java.util.Scanner;

public class MatrixInSpiral {

    public static void spiral(int M, int N, int[][] A){
        int startX = 0;
        int startY = 0;
        int endX = M-1;
        int endY = N-1;
        while (startX<=endX && startY<=endY) {
            for (int j = startY; j <= endY; j++) {
                System.out.print(A[startX][j] + " ");
            }
            startX++;
            for (int i = startX; i <= endX; i++) {
                System.out.print(A[i][endY] + " ");
            }
            endY--;
            if(startX<=endX) {
                for (int j = endY; j >= startY; j--) {
                    System.out.print(A[endX][j] + " ");
                }
                endX--;
            }
            if(startY<=endY) {
                for (int i = endX; i >= startX; i--) {
                    System.out.print(A[i][startY] + " ");
                }
                startY++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[][] A = new int[M][N];
            for (int m=0; m<M; m++){
                for(int n=0; n<N; n++)
                    A[m][n] = sc.nextInt();
            }
            spiral(M, N, A);
        }
    }
}
