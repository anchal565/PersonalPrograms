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

    static class QueueStruc{
        Node node;
        int level;
        QueueStruc(){
            node = null;
            level = 0;
        }
    }

    static SortedMap<Integer, List<Node>>sortedMap = new TreeMap<>();

    public static void verticalOrder(Node root){
        Queue<QueueStruc> queue = new LinkedList<>();
        QueueStruc rootStruc = new QueueStruc();
        rootStruc.node = root;
        rootStruc.level = 0;
        queue.add(rootStruc);

        while (!queue.isEmpty()){
            QueueStruc queueStruc = queue.peek(); //
            List<Node> arrayListt = new ArrayList<>();
            if(queueStruc.node.left != null){
                QueueStruc tempStruc = new QueueStruc();
                tempStruc.node = queueStruc.node.left;
                tempStruc.level = queueStruc.level - 1;
                queue.add(tempStruc);
            }
            if(queueStruc.node.right != null){
                QueueStruc tempStruc = new QueueStruc();
                tempStruc.node = queueStruc.node.right;
                tempStruc.level = queueStruc.level + 1;
                queue.add(tempStruc);
            }
            if(sortedMap.get(queueStruc.level) != null){
                sortedMap.get(queueStruc.level).add(queueStruc.node);

            }
            else {
                arrayListt.add(queueStruc.node);
                sortedMap.put(queueStruc.level,arrayListt);
            }
            queue.poll();
        }
        if(queue.isEmpty()){
            for(Map.Entry a : sortedMap.entrySet()){
                List<Node> listt = (List) a.getValue();
                for(int i =0; i<listt.size(); i++){
                    System.out.print(listt.get(i).data + " ");
                }
            }
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
