import java.util.Scanner;

public class DFSMinValueFromStartToEnd {

    static int min = 20;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] arr = new int[M][N];
        int[][] visited = new int[M][N];

        for(int i =0;i<M; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
                visited[i][j] = 0;
            }
        }
        recur(0, 0,2,2, arr,0, visited);
        System.out.println("min is : "+min);


    }

    public static void recur(int i, int j, int M, int N, int[][] arr, int count, int[][] visited){
        if(i == M-1 && j == N-1){
            if(min > count)
                min = count;
            return ;
        }


        // left
        if(j>0 && visited[i][j-1] != 1) {
            count = count + arr[i][j];
            visited[i][j] = 1;
            recur(i, j - 1, M, N, arr, count, visited);
        }

        //right
        if(j+1 < N && visited[i][j+1] != 1) {
            count = count + arr[i][j];
            visited[i][j] = 1;
            recur(i, j + 1, M, N, arr, count, visited);
        }

        //top
        if(i>0 && visited[i-1][j] != 1) {
            count = count + arr[i][j];
            visited[i][j] = 1;
            recur(i - 1, j, M, N, arr, count, visited);
        }

        //down
        if(i+1 < M && visited[i+1][j] != 1) {
            count = count + arr[i][j];
            visited[i][j] = 1;
            recur(i + 1, j, M, N, arr, count, visited);
        }
    }
}
