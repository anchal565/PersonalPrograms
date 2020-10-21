import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewOfTree {
   // static HashMap<Integer,Object> hashMap = new HashMap<>();
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    /*public static void topView(Node node, int i){
        if(node == null)
            return;
        if(!hashMap.containsKey(i))
            hashMap.put(i, node.data);
        else

        topView(node.left,i-1);
        topView(node.right,i+1);

    }*/

    public static void topViewUsingQueue(Node node, int i){
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(i , node);
        queue.add(node);
       // int j = i;
        while (queue != null){
            int j;
            Node tempNode = queue.poll();
            /*for(Map.Entry entry: hashMap.entrySet()){
                if(tempNode.equals(entry.getValue())){
                    j = entry.getKey();
                    break; //breaking because its one to one map
                }
            }*/


            //int j = hashMap.get(tempNode);
            if(tempNode.left != null){
                if(!hashMap.containsKey(i))
                    hashMap.put(--i, tempNode.left);
                queue.add(tempNode.left);

            }
            ++i;
            if(tempNode.right != null){
                if(!hashMap.containsKey(i))
                    hashMap.put(++i, tempNode.right);
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] arg){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node (3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        //topView(root, 0);
    }
}
