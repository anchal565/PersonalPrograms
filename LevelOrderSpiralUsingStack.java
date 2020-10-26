import java.util.Stack;

public class LevelOrderSpiralUsingStack {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    public static void printSpiral(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node tempNode = stack1.pop();
                if (tempNode.right != null)
                    stack2.push(tempNode.right);
                if (tempNode.left != null)
                    stack2.push(tempNode.left);
                System.out.print(tempNode.data + " ");
            }
            while (!stack2.isEmpty()) {
                Node tempNode = stack2.pop();
                if (tempNode.left != null)
                    stack1.push(tempNode.left);
                if (tempNode.right != null)
                    stack1.push(tempNode.right);
                System.out.print(tempNode.data + " ");
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
         root.right.left = new Node(22);
        root.right.right = new Node(30);
        printSpiral(root);
    }
}
