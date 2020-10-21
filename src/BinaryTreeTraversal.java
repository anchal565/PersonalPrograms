public class BinaryTreeTraversal {
    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }

    BinaryTreeTraversal(){
        root=null;
    }

    public void preOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] arg){
        BinaryTreeTraversal binaryTree = new BinaryTreeTraversal();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
    }
}
