//Deepest left leaf node in a binary tree
public class DeepestLeftLeafNode {
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static int deepestLeaf = 0;
    static int levelCheck = 0;
    public static void deepestLeftLeaf(Node node, int check, int level){
        if (node == null)
            return;
        else{
            if(check == 0 && node.left == null && node.right == null){
                if(levelCheck < level) {
                    levelCheck = level;
                    deepestLeaf = node.data;
                }
            }
            else{
                deepestLeftLeaf(node.left, 0, level+1);
                deepestLeftLeaf(node.right, 1, level+1);
            }
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        /*root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.right.right.right = new Node(10);*/
        root.left.left = new Node(4);
        root.left.left.left = new Node(9);
        root.left.left.left.left = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        deepestLeftLeaf(root, 0, 1);
        System.out.println("Deepest left leaf node : "+deepestLeaf);
    }
}
