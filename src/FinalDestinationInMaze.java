import java.util.Scanner;

public class FinalDestinationInMaze {
    static int x , y , minSteps;

    public static void recur(int i, int j, boolean[][] visibility, int steps, int[][] matrix, int m, int n){
        if(i == x && j == y){
            if(minSteps == -1 || minSteps > steps)
                minSteps = steps;
            return;
        }


        //left
        if(j>0 && matrix[i][j-1] == 1 && visibility[i][j-1] == false) {
            visibility[i][j - 1] = true;
            recur(i, j-1, visibility, steps+1, matrix, m , n);
            visibility[i][j-1] = false;
        }

        //right
        if(j+1< n && matrix[i][j+1] == 1 && visibility[i][j+1] == false) {
            visibility[i][j + 1] = true;
            recur(i, j+1, visibility, steps +1, matrix, m, n);
            visibility[i][j+1] = false;
        }

        //top
        if(i>0 && matrix[i-1][j]==1 && visibility[i-1][j] == false) {
            visibility[i-1][j] = true;
            recur(i-1, j, visibility, steps+1,matrix, m, n);
            visibility[i-1][j] = false;
        }

        //bottom
        if(i+1<m && matrix[i+1][j]==1 && visibility[i+1][j] == false) {
            visibility[i+1][j] = true;
            recur(i+1, j,visibility, steps+1,matrix, m, n);
            visibility[i+1][j] = false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T; t++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] matrix = new int[m][n];

            boolean[][] visibility = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = sc.nextInt();
                    visibility[i][j] = false;
                }
            }
            x = sc.nextInt();
            y = sc.nextInt();
            minSteps = -1;
            if(matrix[0][0] == 0)
                System.out.println(-1);
            else{
            recur(0, 0, visibility, 0, matrix,  m, n);
            //System.out.println();
            System.out.println(minSteps);}
        }
    }
}
