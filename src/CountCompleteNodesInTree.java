public class CountCompleteNodesInTree {
    static class Node{
        Node left,right;
        int data;
        Node(int d){
            data = d;
        }
    }
    public static int countNodes(Node root) {
        if(root == null)
            return 0;
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        int count = countNodes(root);
        System.out.println(count);
    }
}
