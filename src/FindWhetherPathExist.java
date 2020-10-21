import java.util.Scanner;

public class FindWhetherPathExist {
    static int check =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T;t++){
            int N = sc.nextInt();
            int start_row=0, start_col=0, end_row =0, end_col=0;
            int[][] matrix = new int[N][N];
            int[][] visibility = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    matrix[i][j] = sc.nextInt();
                    if(matrix[i][j] == 1){
                        start_row = i;
                        start_col = j;
                    }
                    else if(matrix[i][j] == 2){
                        end_row=i;
                        end_col=j;
                    }

                }
            }
            //System.out.println("start is : "+start_row+" "+start_col+" des is : "+end_row+" "+end_col);
            visibility[start_row][start_col] = 1;
            boolean check = recur(start_row, start_col, end_row, end_col, matrix, visibility, N);
            System.out.println(check);

        }
    }

    public static boolean recur(int i, int j, int des_row, int des_col, int[][] matrix, int[][] visibility, int N){
        boolean check = false;
        if(i==des_row && j == des_col){
            check = true;
            return check;
        }


        if(i==N-1 && j!= N-1 || (i!= N-1 && j==N-1))
            return check;


        //top
        if(i>0 && matrix[i-1][j] != 0 && visibility[i-1][j] != 1){
            visibility[i-1][j] = 1;
            check  = check || recur(i-1, j, des_row, des_col, matrix, visibility, N);
            visibility[i-1][j] = 0;
        }

        //bottom
        if(i+1<N && matrix[i+1][j] != 0 && visibility[i+1][j] != 1){
            visibility[i+1][j] = 1;
            check = check || recur(i+1, j, des_row, des_col, matrix, visibility, N);
            visibility[i+1][j] = 0;
        }

        //left
        if(j>0 && matrix[i][j-1] != 0 && visibility[i][j-1] != 1){
            visibility[i][j-1] = 1;
            check = check || recur(i, j-1, des_row, des_col, matrix, visibility, N);
            visibility[i][j-1] = 0;
        }

        //right
        if(i>0 && matrix[i][j+1] != 0 && visibility[i][j+1] != 1){
            visibility[i][j+1] = 1;
            check = check || recur(i, j+1, des_row, des_col, matrix, visibility, N);
            visibility[i][j+1] = 0;
        }
        return check;
    }
}
