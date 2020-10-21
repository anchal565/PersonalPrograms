import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static Queue<Node> queue = new LinkedList<>();
    static Node root;
   static class Node{
        int data;
        Node left, right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    LevelOrderTraversal(){
        root = null;
    }

    public int height(Node node){
        int lheight = 0;
        int rheight = 0;
        if(node == null)
            return 0;
        else{
            lheight = 1 + height(node.left);
            rheight = 1 + height(node.right);
        }
        if(lheight > rheight)
            return lheight;
        else
            return rheight;
    }

    public void traversalUsingQueue(Node node){
       //Queue<Node> queue = new LinkedList<>();
        queue.add(node);
       while(!queue.isEmpty()){
           Node tempNode = queue.poll();
           System.out.print(tempNode.data + " ");
           if(tempNode.left != null)
               queue.add(tempNode.left);
           if(tempNode.right != null)
               queue.add(tempNode.right);
           /*traversalUsingQueue(tempNode.left);
           traversalUsingQueue(tempNode.right);*/

       }
    }

    public void traversalUsingMethod(int level, Node node){
       if(node == null)
           return;
       if(level == 1)
           System.out.print(node.data + " ");
       else{
           traversalUsingMethod(level-1, node.left);
           traversalUsingMethod(level-1, node.right);
       }

    }

    public static void main(String[] arg){
        LevelOrderTraversal treeObj = new LevelOrderTraversal();
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left = new Node(4);
        int height = treeObj.height(root);
        System.out.println("Height of tree is : "+height);

        System.out.println("Traversal using method is : ");
        for(int i=1; i<=height;i++){
            treeObj.traversalUsingMethod(i, root);
        }

        System.out.println("Traversal using queue is : ");
        treeObj.traversalUsingQueue(root);
    }
}
