public class SearchInBinaryTree {
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    public Node searchBST(Node root, int val) {
        if(root == null)
            return null;
        if(root.data == val)
            return root;
        if(val < root.data)
            searchBST(root.left, val);
        else
            searchBST(root.right, val);
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
        SearchInBinaryTree searchInBinaryTree = new SearchInBinaryTree();
        Node node = searchInBinaryTree.searchBST(root,2);
        searchInBinaryTree.printTree(node);
    }
}
