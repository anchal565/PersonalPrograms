import java.util.*;

public class PrintTreeInVerticalOrder {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    static SortedMap<Integer, List<Integer>> sortedMap;
    static void verticalOrder(Node root){
        sortedMap = new TreeMap<>();
        verticalOrderPerLevel(root,0);

        for(Map.Entry a : sortedMap.entrySet()){
            List<Integer> list = (List)(a.getValue());
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }


        }
    }

    public static void verticalOrderPerLevel(Node root, int level){
        if(root == null)
            return;
        else{
            if(sortedMap.containsKey(level)){
                List<Integer> arrayList = sortedMap.get(level);
                arrayList.add(root.data);
                sortedMap.put(level, arrayList);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(root.data);
                sortedMap.put(level, list);
            }
            verticalOrderPerLevel(root.left, level-1);
            verticalOrderPerLevel(root.right, level+1);
        }
    }

    public static void main(String[] args) {
        root = new Node(20);
        root.left= new Node(8);
        root.left.left = new Node(5);
        root.left.left.left = new Node(15);
        root.right = new Node(25);
        root.left.right = new Node(12);
        root.left.right.right = new Node(7);
        verticalOrder(root);
    }
}
