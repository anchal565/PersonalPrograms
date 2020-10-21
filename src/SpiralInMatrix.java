import java.util.Scanner;

public class SpiralInMatrix {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int rowLength=sc.nextInt();
        int colLength=sc.nextInt();
        int[][] arr=new int[rowLength][colLength];
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int istart=0;
        int jstart=0;
        int iend=rowLength-1;
        int jend=colLength-1;


        while(iend>=istart && jend>=jstart) {


            //right
            if(istart<=iend) {
                for (int j = jstart; j <= jend; j++) {
                    System.out.print(arr[istart][j] + " ");

                }
            }
            istart++;

            //down
            if(jstart<=jend) {
                for (int i = istart; i <= iend; i++) {
                    System.out.print(arr[i][jend] + " ");

                }
            }
            jend--;


            //left
            if(istart<=iend) {
                for (int j = jend; j >= jstart; j--) {
                    System.out.print(arr[iend][j] + " ");
                }
            }
            iend--;


            //top
            if(jstart<=jend) {
                for (int i = iend; i >= istart; i--) {
                    System.out.print(arr[i][jstart] + " ");
                }
            }
            jstart = jstart + 1;
        }






    }
}
