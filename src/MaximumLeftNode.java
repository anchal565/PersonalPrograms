public class MaximumLeftNode {
    static int max = Integer.MIN_VALUE;
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void maximumLeftNode(Node node, int check){
        if(node == null)
            return;
        if(check == 1){
                if(max < node.data)
                    max = node.data;
        }
        {
            maximumLeftNode(node.left, 1);
            maximumLeftNode(node.right, 0);
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        //root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        maximumLeftNode(root, 0);
        System.out.println("Maximum is : "+max);
    }

}
