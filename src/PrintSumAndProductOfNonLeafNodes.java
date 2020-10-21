//Print Sum and Product of all Non-Leaf nodes in Binary Tree
public class PrintSumAndProductOfNonLeafNodes {
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static int sum = 0;
    static int product = 1;
    public static void sumAndProduct(Node node){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            return;
        }
        else {
            sum += node.data;
            product *= node.data;
            sumAndProduct(node.left);
            sumAndProduct(node.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        sumAndProduct(root);
        System.out.println("Sum is : "+sum);
        System.out.println("Product is : "+product);
    }
}
