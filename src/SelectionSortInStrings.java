import java.util.Scanner;

public class SelectionSortInStrings {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] inputArr=new String[n];
        for(int i=0;i<n;i++){
            inputArr[i]=sc.next();
        }


        for(int i=0;i<n-1;i++){
            int min_index=i;

            for(int j=i+1;j<n;j++) {
                int k=0;
                while (k < inputArr[j].length() && k<inputArr[min_index].length()) {
                    if ((int) (inputArr[j].charAt(k)) < (int) (inputArr[min_index].charAt(k))) {

                        min_index = j;
                        break;

                    }
                    else if ((int) (inputArr[j].charAt(k)) == (int) (inputArr[min_index].charAt(k))) {
                        k++;
                    }
                    else
                        break;



                }
            }

            //swap
            String temp=inputArr[min_index];
            inputArr[min_index]=inputArr[i];
            inputArr[i]=temp;


        }

        System.out.println("After sorting : ");
        for(int i=0;i<inputArr.length;i++){
            System.out.print(inputArr[i]+ " ");
        }

    }



}
