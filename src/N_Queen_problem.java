import java.util.Scanner;

public class N_Queen_problem {

    static boolean checkFlag = false;
    public static int[][] recur(int i, int[][] matrix, int[][] visited, int count, int N, boolean found){
        if (count == N){
            checkFlag = true;
            //System.out.println("HIIIII");
            /*for(int x=0;x<N;x++){
                for(int y=0;y<N;y++){
                    System.out.print(matrix[x][y]+" ");
                }
                System.out.println();
            }*/
            return matrix;
        }
        if(i >= N )
            return matrix;

        /*if(checkFlag ==  true)
            return  matrix;*/



        for(int k=0; k<N; k++) {
            if (lyingOnBoundary(i, k, visited, N) == true) {
                matrix[i][k] = 1;
                visited[i][k] = 1;

                    recur(i + 1, matrix, visited, count+1, N, found);
                    /*if(checkFlag == true)
                        return matrix;*/
                matrix[i][k] = 0;
                visited[i][k] = 0;
            }

        }
        return matrix;
    }

    public static boolean lyingOnBoundary(int i, int j, int[][] visited, int N){
            for(int l=0; l<N; l++){
                //horizontally
                if(j+l<N && visited[i][j+l] == 1){
                    return false;
                }
                if(j-l >=0 && visited[i][j-l] == 1){
                    return false;
                }
                //vertically
                if(i+l<N && visited[i+l][j] == 1){
                    return false;
                }
                if(i-l >=0 && visited[i-l][j] == 1){
                    return false;
                }

                //diagnol1
                if(i+l <N && j+l<N && visited[i+l][j+l] == 1)
                    return false;
                if(i-l >=0 && j-l >=0 && visited[i-l][j-l] == 1)
                    return false;
                //diagnol2
                if(i+l<N && j-l >=0 && visited[i+l][j-l] == 1)
                    return false;
                if(i-l>=0 && j+l<N && visited[i-l][j+l] == 1)
                    return false;
            }
            return true;
    }



    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        int[][] visited = new int[N][N];
        boolean flag;

        matrix = recur(0, matrix, visited, 0, N,false);
        if(checkFlag == false)
            System.out.println("No possible solution");
        else {
            for (int k = 0; k < N; k++) {
                for (int l = 0; l < N; l++)
                    System.out.print(matrix[k][l] + " ");
                System.out.println();
            }
        }


    }
}
