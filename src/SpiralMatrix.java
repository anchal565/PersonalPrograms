import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null)
            return new ArrayList<Integer>();
        int M = matrix.length;
        if(M==0)
            return new ArrayList<Integer>();
        int N = matrix[0].length;
        if(M==0 || N==0)
            return new ArrayList<Integer>();
        boolean[][] visited = new boolean[M][N];
        List<Integer> result = new ArrayList<>();
        boolean topDirection = false;
        result.add(matrix[0][0]);
        visited[0][0] = true;
        int count = 1, i=0, j=0;
        while(count < M*N){
            //right
            if(topDirection == false && j+1<N && visited[i][j+1] == false){
                result.add(matrix[i][j+1]);
                visited[i][j+1] = true;
                j++;
                count ++;
            }
            //bottom
            else if(i+1<M && visited[i+1][j] == false){
                result.add(matrix[i+1][j]);
                visited[i+1][j] = true;
                i++;
                count ++;
            }
            //left
            else if(j>0 && visited[i][j-1] == false){
                result.add(matrix[i][j-1]);
                visited[i][j-1] = true;
                j--;
                count ++;
            }
            //top
            else if(i>0 && visited[i-1][j] == false){
                result.add(matrix[i-1][j]);
                visited[i-1][j] = true;
                i--;
                count++;
                topDirection = true;
            }
            else{
                topDirection = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,2,3},
                {4,5,6}};
        List<Integer> result = spiralOrder(matrix);
        for(Integer value : result){
            System.out.print(value + " ");
        }
    }
}
