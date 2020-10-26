//Given a binary tree, the task is to find the sum of all the nodes whose parent is even.
public class SumOfChildOfEvenParent {
    static Node root;
    static int sum = 0;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right =null;
        }
    }

    public static void sumOfNodes(Node node){
        if(node == null)
            return;
        if(node.data %2 == 0){
            if(node.left != null)
                sum = sum + node.left.data;
            if(node.right != null)
                sum = sum + node.right.data;

        }
        sumOfNodes(node.left);
        sumOfNodes(node.right);
    }

    public static void main(String[] args) {
        root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(1);
        sumOfNodes(root);
        System.out.println("Sum : "+sum);
    }
}
