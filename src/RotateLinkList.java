import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class RotateLinkList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t < T; t++){
            int N =sc.nextInt();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for(int i=0; i<N; i++){
                linkedList.add(sc.nextInt());
            }
            int k = sc.nextInt();
            ListIterator<Integer> listIteratorStart = linkedList.listIterator(0);
            ListIterator<Integer> listIteratorEnd = linkedList.listIterator(k);
            ListIterator<Integer> listIteratorMid = linkedList.listIterator(k-1);
            System.out.println("Start "+listIteratorStart.next());
            System.out.println(listIteratorMid.next()+" Mid");
            System.out.println(listIteratorEnd.next() + " End");
            //Integer temp = listIteratorMid.next();
            listIteratorMid.next();
            listIteratorMid.set(null);
            //listIterator.set(null);
            //System.out.println("temp is : "+temp);
            /*while(listIteratorMid.hasNext()){
                System.out.println(listIteratorMid.next());
            }*/
            listIteratorMid.set(listIteratorStart.next());

            //listIteratorEnd.set(listIteratorStart.next());
            //linkedList.set(0,temp);
            System.out.println("Reverse is : "+linkedList);
            //listIterator.next()=linkedList.getFirst();
        }
    }
}
