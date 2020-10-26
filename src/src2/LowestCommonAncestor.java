public class LowestCommonAncestor {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    //static Node ancestor;
    public static Node LCA(Node node, int n1, int n2){
        if(node == null)
            return null;


        else if(node.data > n1 && node.data>n2)
                return LCA(node.left, n1, n2);
            else if(node.data < n1 && node.data<n2)
                return LCA(node.right, n1, n2);
        else
        return node;
    }

    public static void main(String[] args) {
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        /*root.right.right = new Node(7);
        root.right.right.right = new Node(8);*/
        Node node = LCA(root, 10, 22);
        System.out.println(node.data);
    }
}
