import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class BottomView {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }


    static SortedMap<Integer, Integer> sortedMap;
    public static void bottomView(Node root){
         sortedMap = new TreeMap<>();
        bottomViewPerLevel(root,0);
    }

    public static void bottomViewPerLevel(Node root, int cellIndex){
        if(root == null)
            return;
        else{
            sortedMap.put(cellIndex, root.data);
            bottomViewPerLevel(root.left, cellIndex-1);
            bottomViewPerLevel(root.right, cellIndex+1);
        }

    }


    public static void main(String[] args) {
        root = new Node(20);
        /*root.left= new Node(8);
        root.left.left = new Node(5);
        root.left.left.left = new Node(15);*/
        root.right = new Node(22);
        root.right.right = new Node(25);
        root.right.right.right = new Node(125);
        /*root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.right.left.right = new Node(14);*/
        bottomView(root);
        //Set set = sortedMap.entrySet();
        /*Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry m = (Map.Entry) iterator.next();
            System.out.println(m.getValue());
        }*/
        for(Map.Entry a : sortedMap.entrySet()){
            System.out.println(a.getValue());
        }
    }
}
