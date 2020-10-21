import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N_Queen_for_leet {
    static boolean checkFlag = false;
    static List<List<String>> finalList ;
    public static List<List<String>> recur(int i, char[][] matrix, int[][] visited, int count, int N, boolean found){
        //finalList = new ArrayList<List<String>>();

        if (count == N){
            checkFlag = true;
            List<String> listInRow = new ArrayList<>();
            //String stringInRow = "";
            //System.out.println("HIIIII");
            for(int x=0;x<N;x++){
                String stringInRow=new String();
                for(int y=0;y<N;y++){
                    stringInRow=stringInRow.concat(String.valueOf(matrix[x][y]));
                    //System.out.print(matrix[x][y]+" ");
                }
                listInRow.add(stringInRow);

                //System.out.println();
            }
            finalList.add(listInRow);
            /*System.out.println("In Method");
            for(List<String> a : finalList){
                for(String b : a)
                    System.out.println(b);
                }*/
            return finalList;
        }
        if(i >= N )
            return finalList;

        /*if(checkFlag ==  true)
            return  matrix;*/



        for(int k=0; k<N; k++) {
            if (lyingOnBoundary(i, k, visited, N) == true) {
                matrix[i][k] = 'Q';
                visited[i][k] = 1;

                recur(i + 1, matrix, visited, count+1, N, found);
                    /*if(checkFlag == true)
                        return matrix;*/
                matrix[i][k] = '.';
                visited[i][k] = 0;
            }

        }
        return finalList;
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
        char[][] matrix = new char[N][N];
        int[][] visited = new int[N][N];
        finalList= new ArrayList<List<String>>();

        boolean flag;
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++)
                matrix[k][l] = '.';
        }

        finalList = recur(0, matrix, visited, 0, N,false);
        if(checkFlag == false)
            System.out.println("No possible solution");
        else {
            for(List<String> a : finalList){
                for(String b : a){
                    System.out.println(b);
                }
            }

        }


    }
}
