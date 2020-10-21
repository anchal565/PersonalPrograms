import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Given a column number, find its corresponding Excel column name. Following are more examples.
//Output          Input
// 26             Z
// 51             AY
// 52             AZ
// 80             CB
// 676            YZ
// 702            ZZ
public class ExcelNameToColumnNum {
    public static int mostOptimised(String s){
        int power = 1, colNum =0;
        for(int i=s.length()-1; i>=0; i--){
            colNum += (char)(s.charAt(i) - 'A' +1) * power;
            power*=26;
        }
        return colNum;
    }
    public static int secondMethod(String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        for(int i=0; i<26; i++){
            map.put((char)('A' + i), i+1);
        }
        int i=0, colNum = 0, length = s.length();
        while(i < s.length()){
            colNum += (Math.pow(26, length-1) * map.get(s.charAt(i)));
            length--;
            i++;
        }
        return colNum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cellName = sc.next();
        char[] cells = cellName.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A',1);
        hashMap.put('B',2);
        hashMap.put('C',3);
        hashMap.put('D',4);
        hashMap.put('E',5);
        hashMap.put('F',6);
        hashMap.put('G',7);
        hashMap.put('H',8);
        hashMap.put('I',9);
        hashMap.put('J',10);
        hashMap.put('K',11);
        hashMap.put('L',12);
        hashMap.put('M',13);
        hashMap.put('N',14);
        hashMap.put('O',15);
        hashMap.put('P',16);
        hashMap.put('Q',17);
        hashMap.put('R',18);
        hashMap.put('S',19);
        hashMap.put('T',20);
        hashMap.put('U',21);
        hashMap.put('V',22);
        hashMap.put('W',23);
        hashMap.put('X',24);
        hashMap.put('Y',25);
        hashMap.put('Z',26);
        int num = 0;
        int j=0;
        for(int i= cellName.length() -1; i>=0; i--){
            num = (int) (num + hashMap.get(cellName.charAt(i)) * Math.pow(26, j));
            j++;
        }
        System.out.println(num);
    }
}
