public class InvertBinaryTree {
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public Node invertTree(Node root){
        if(root == null)
            return null;
        else{
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;

        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void printTree(Node node){
        if(node == null)
            return;
        System.out.print(node.data+" ");
        printTree(node.left);
        printTree(node.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(root);
        invertBinaryTree.printTree(root);
    }
}
