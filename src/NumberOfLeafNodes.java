public class NumberOfLeafNodes {

    static Node root;
    static int count =0;
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public static int countLeaf(Node node){
        if(node == null)
            return count;
        if(node!= null && node.left == null && node.right == null)
            count++;
        else {
            countLeaf(node.left);
            countLeaf(node.right);
        }
        return count;
    }
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        int count = countLeaf(root);
        System.out.println("Leaf node coutn is : "+count);
    }
}
