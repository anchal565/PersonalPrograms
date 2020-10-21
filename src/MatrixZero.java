import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixZero {

    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }


        List<Integer> arrayList1=new ArrayList<Integer>();
        List<Integer> arrayList2=new ArrayList<Integer>();

        int x=0,y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(!arrayList1.contains(i))
                        arrayList1.add(i);
                    if(!arrayList2.contains(j))
                        arrayList2.add(j);
                }
            }
        }

        System.out.println("X coordinates are : ");
        for(int i=0;i<arrayList1.size();i++){
            System.out.print(arrayList1.get(i) + " ");
        }

        System.out.println();
        System.out.println("Y coordinates are : ");
        for(int i=0;i<arrayList2.size();i++){
            System.out.print(arrayList2.get(i)+" ");
        }
        System.out.println();

        for(int i=0;i<arrayList1.size();i++){
            for(int j=0;j<n;j++){
                matrix[arrayList1.get(i)][j]=0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<arrayList2.size();j++){
                matrix[i][arrayList2.get(j)]=0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
