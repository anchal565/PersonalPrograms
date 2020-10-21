import java.util.LinkedList;
import java.util.Queue;

public class InsertionInLevel {
    static Node root;
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    InsertionInLevel(){
        root = null;
    }

    public int height(Node root){
        int lheight, rheight =0;
        if(root == null)
            return 0;
        else{
            lheight = 1+height(root.left);
            rheight = 1+height(root.right);
        }
        if(lheight > rheight)
            return lheight;
        else
            return rheight;
    }

    /*public void insertion(Node node, int key, int level){

        if(node.left == null){
            node.left = new Node(key);
            return;
        }
        if(node.right == null){
            node.right = new Node(key);
            return;
        }
        else {
            insertion(node.left, key, level+1);
            insertion(node.right, key, level+1);
        }
    }*/

    public void insertionUsingQueue(Node node, int key){
        if(node == null){
            root=new Node(key);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node tempNode = queue.poll();
            if(tempNode.left == null){
                tempNode.left = new Node(key);
                return;
            }
            else if(tempNode.right == null){
                tempNode.right = new Node(key);
                return;
            }
            else{
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            }


        }
    }

    public void printInLevel(Node node){
        Queue<Node> queue = new LinkedList<>();
        if(node == null)
            return;
        else
        {
            queue.add(node);
            while(!queue.isEmpty()){
                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");
                if(tempNode.left != null)
                    queue.add(tempNode.left);
                if(tempNode.right != null)
                    queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] ar){
        InsertionInLevel classObject = new InsertionInLevel();
        root= new Node(1);
        root.left = new Node(2);
        root.right= new Node(3);
        root.left.left = new Node(4);
        root.left.left = new Node(9);

        root.right.left = new Node(6);
        root.left.left.left = new Node(7);
        int height = classObject.height(root);
        classObject.insertionUsingQueue(root, 5);

        classObject.printInLevel(root);
    }
}
