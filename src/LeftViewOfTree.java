import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }

    }

    LeftViewOfTree(){
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

    public static boolean leftView(Node node, int i){

        boolean flag = false;
        if(node == null)
            return false;
        if(i == 1 & node !=null) {
            flag = true;
            System.out.print(node.data + " ");
            return true;
        }
        else{
            flag = leftView(node.left, i-1);
            if(flag != true)
               flag = leftView(node.right, i-1);
            return flag;
        }
    }


    public void leftViewUsingQueuee(Node node){
        if(node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        queue.add(node);
        queue.add(null);
        level = level+1;
        boolean flag = false;

        while(!queue.isEmpty()){
            if(queue.peek() != null && flag == false){
                System.out.print(queue.peek().data + " ");
                flag = true;
            }
            while(queue.peek() != null){
               // if(queue.peek() != null){
                    Node tempNode = queue.poll();
                    if(tempNode.left != null)
                        queue.add(tempNode.left);
                    if(tempNode.right != null)
                        queue.add(tempNode.right);
                //}
            }
            if(queue.peek() == null)
            {
                queue.poll();
                flag = false;
            }
            if(queue.size()>1)
                queue.add(null);
        }
    }

    public static  void main(String[] a){
        LeftViewOfTree classObj = new LeftViewOfTree();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        /*root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);*/
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);


        System.out.println("Height of tree is : "+classObj.height(root));
        int i = 1;
        while(i<=classObj.height(root)){
            leftView(root , i);
            i++;
        }
        System.out.println("Left view using queue is : ");
        classObj.leftViewUsingQueuee(root);
    }
}
