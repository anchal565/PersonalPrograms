import java.util.*;

public class FirstNonRepeatiningCharInStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T>0){
            int N = sc.nextInt();
            Queue<Character> queue = new LinkedList<>();
            LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
            char[] arr = new char[N];
            //int k = 0;
            for (int i =0; i <N; i++){
                arr[i] = sc.next().charAt(0);
                if(map.containsKey(arr[i])){
                    map.put(arr[i], map.get(arr[i])+1);
                }
                else{
                   map.put(arr[i],1);
                }
                int k = 0;
                for(Map.Entry<Character, Integer> entry : map.entrySet()){
                    if(entry.getValue() == 1) {
                        System.out.print(entry.getKey() + " ");
                        break;
                    }
                    k++;
                }
                if(k == map.size())
                    System.out.print("-1 ");


                /*if(queue.isEmpty()){
                    queue.add(arr[i]);
                    System.out.print(queue.peek()+" ");

                }
                else if(queue.peek() == arr[i]){
                    queue.poll();
                    if(queue.isEmpty())
                        System.out.print("-1 ");
                    else
                    System.out.print(queue.peek()+" ");

                }
                else {
                    queue.add(arr[i]);
                    System.out.print(queue.peek()+" ");
                }*/
            }

            System.out.println();
            T--;
        }
    }
}
