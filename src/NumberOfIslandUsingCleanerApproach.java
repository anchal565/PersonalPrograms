import java.util.Scanner;

public class NumberOfIslandUsingCleanerApproach {


    static int count = 0;

    static int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        count =0;
        int rows = binaryMatrix.length;
        int cols = binaryMatrix[0].length;
        int[] trackOnRow = new int[] {0, 0, -1, 1, -1, 1, 1,  -1};
        int[] trackOnCol = new int[] {1, -1, 0, 0, 1,  1, -1,  -1};


            /*for(int i=0; i<rows; i++){
                int columns = binaryMatrix[i].length;
            }*/
        int[][] visitedCell = new int[rows][cols];
        for(int i=0;i <rows; i++){
            for(int j=0; j<cols; j++){
                visitedCell[i][j] = 0;
            }
        }
        for(int k = 0; k<rows; k++){
            for(int j=0; j<cols; j++) {
                count = count + recur(k, j, binaryMatrix, visitedCell, 0, true, rows, cols, trackOnRow, trackOnCol);
            }

        }
        System.out.println("Count of islands is : "+count);
        return count ;
    }


    static int recur(int i, int j, int[][] binaryMatrix, int[][] visitedCell, int countForSingleIsland, boolean check, int rows, int cols
    ,int[] trackOnRow, int[] trackOnCol){
        if(i == rows || j == cols)
            return countForSingleIsland;

        if(binaryMatrix[i][j] == 0)
            return countForSingleIsland;

        if(binaryMatrix[i][j] == 1 && visitedCell[i][j] != 1){
            visitedCell[i][j] = 1;
            if(check == true)
                countForSingleIsland = countForSingleIsland + 1;



                for (int y=0; y<trackOnCol.length; y++){
                    if(i+trackOnRow[y] >= 0 && i+trackOnRow[y] < rows
                            && j+trackOnCol[y] >= 0 && j+trackOnCol[y] < cols
                            && visitedCell[i+trackOnRow[y]][j+trackOnCol[y]] != 1) {
                                recur(i + trackOnRow[y], j + trackOnCol[y], binaryMatrix, visitedCell, countForSingleIsland,
                                false, rows, cols, trackOnRow, trackOnCol);
                    }
                }

        }
        return countForSingleIsland;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++) {
            int rows = sc.nextInt();
            int col = sc.nextInt();
            int[][] binaryMatrix = new int[rows][col];
            for (int k = 0; k < rows; k++) {
                for (int l = 0; l < col; l++)
                    binaryMatrix[k][l] = sc.nextInt();
            }

            getNumberOfIslands(binaryMatrix);
        }
    }
}
