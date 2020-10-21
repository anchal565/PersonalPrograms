import java.util.HashMap;
import java.util.Scanner;

//Given a column number, find its corresponding Excel column name. Following are more examples.
//Input          Output
// 26             Z
// 51             AY
// 52             AZ
// 80             CB
// 676            YZ
// 702            ZZ
public class ExcelColumnNumberToName {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        HashMap<Integer, Character> hashMap = new HashMap<>();
        hashMap.put(1, 'A');
        hashMap.put(2,'B');
        hashMap.put(3,'C');
        hashMap.put(4,'D');
        hashMap.put(5,'E');
        hashMap.put(6,'F');
        hashMap.put(7,'G');
        hashMap.put(8,'H');
        hashMap.put(9,'I');
        hashMap.put(10,'J');
        hashMap.put(11,'K');
        hashMap.put(12,'L');
        hashMap.put(13,'M');
        hashMap.put(14,'N');
        hashMap.put(15,'O');
        hashMap.put(16,'P');
        hashMap.put(17,'Q');
        hashMap.put(18,'R');
        hashMap.put(19,'S');
        hashMap.put(20,'T');
        hashMap.put(21,'U');
        hashMap.put(22,'V');
        hashMap.put(23,'W');
        hashMap.put(24,'X');
        hashMap.put(25,'Y');
        hashMap.put(0,'Z');
        StringBuilder cellName = new StringBuilder();
        int rem = 0;
        while (num>0){
            rem = num % 26;
            cellName.append(hashMap.get(rem));
            if(rem == 0)
                num = num/26 - 1;
            else
                num = num/26;
        }
        for(int i=cellName.length()-1; i>=0; i--){
            System.out.print(cellName.charAt(i));
        }
        System.out.println();
    }
}
