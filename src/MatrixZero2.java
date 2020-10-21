
//Not a complete solution
import java.util.Scanner;

public class MatrixZero2 {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0) {
                    int x=i,y=0;
                    while(y<n && matrix[x][y]!=0){
                        if(matrix[x][y]==0 && x==i && y==j)
                        matrix[x][y]=-1;
                        y++;
                    }
                    y=j;
                    x=0;
                    while(x<n && matrix[x][y]!=0){
                        matrix[x][y]=-1;
                        x++;
                    }
                }

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
