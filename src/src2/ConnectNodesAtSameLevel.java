import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    static Node root;
    static class Node
    {
        int data;
        Node left, right, nextRight;
        Node(int x)
        {
            this.data = x;
            left = right = nextRight = null;
        }
    }

    public static void connect(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node tempNode = queue.poll();
            if(queue.isEmpty())
                break;
            if(tempNode == null)
                tempNode = queue.poll();
            while(tempNode != null){
                if(queue.isEmpty())
                    break;
                if(tempNode.left != null)
                    queue.add(tempNode.left);
                if(tempNode.right != null)
                    queue.add(tempNode.right);
                tempNode.nextRight = queue.peek();
                tempNode = queue.poll();
            }
            if(queue.isEmpty())
                break;
            queue.add(null);
        }
    }

    public static void inOrder(Node root){
        if(root == null)
            return;
        else{
            inOrder(root.left);
            if(root.nextRight == null)
                System.out.println(root.data+" "+null);
            else
                System.out.print(root.data + " "+root.nextRight.data);
            System.out.println();
            inOrder(root.right);
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
        connect(root);
        inOrder(root);
    }
}
