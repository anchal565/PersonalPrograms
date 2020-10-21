import java.util.Stack;

//print the leaf nodes from left to right
public class PrintLeafNodes {
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void printLeftToRightLeaf(Node node){
        if(node == null)
            return;
        else if(node.left == null && node.right == null)
            System.out.print(node.data+" ");
        else {
            printLeftToRightLeaf(node.left);
            printLeftToRightLeaf(node.right);

        }
    }

    public static void printLeftToRightUsingOneStack(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node node1 = stack.pop();
            if(node1.left == null && node1.right == null) {
                System.out.print(node1.data + " ");

            }
            else {
                if (node1.right != null)
                    stack.push(node1.right);
                if (node1.left != null)
                    stack.push(node1.left);
            }

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        /*root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.left.left.left = new Node(10);
        root.left.left.right = new Node(11);
        root.right.right.left = new Node(8);*/
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        printLeftToRightLeaf(root);
        System.out.println();
        printLeftToRightUsingOneStack(root);
    }
}
