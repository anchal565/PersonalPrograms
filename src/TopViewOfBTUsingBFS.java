import java.util.*;

class QueueStruc{
    int distance;
    TreeNode node;
}
public class TopViewOfBTUsingBFS {
    Queue<QueueStruc> queue;
    TreeMap<Integer, Integer> treeMap;

    public void topView(TreeNode root){
        queue = new LinkedList<>();
        treeMap = new TreeMap<>();
        QueueStruc queueStruc = new QueueStruc();
        queueStruc.distance = 0;
        queueStruc.node = root;
        queue.add(queueStruc);
        while (!queue.isEmpty()){
            queueStruc = queue.poll();

            if(treeMap.get(queueStruc.distance) == null)
                treeMap.put(queueStruc.distance, queueStruc.node.data);

            if(queueStruc.node.left != null){
                QueueStruc queueStruc1 = new QueueStruc();
                queueStruc1.distance = queueStruc.distance -1;
                queueStruc1.node = queueStruc.node.left;
                queue.add(queueStruc1);
            }
            if(queueStruc.node.right != null){
                QueueStruc queueStruc1 = new QueueStruc();
                queueStruc1.distance = queueStruc.distance +1;
                queueStruc1.node = queueStruc.node.right;
                queue.add(queueStruc1);
            }

        }
        for(Map.Entry<Integer, Integer> map : treeMap.entrySet()){
            System.out.print(map.getValue()+" ");
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        TopViewOfBTUsingBFS topView = new TopViewOfBTUsingBFS();
        topView.topView(root);
        //System.out.println(width);
    }
}
