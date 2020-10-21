public class CountLeafNodes {
    static Node root;
    static int count =0;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    private static int countLeaves(Node node){
        if(node.left == null && node.right == null){
            count++;
            return count;
        }
        else{
            countLeaves(node.left);
            countLeaves(node.right);
        }
        return count;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left= new Node (2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        countLeaves(root);
        System.out.println(count);
    }
}
