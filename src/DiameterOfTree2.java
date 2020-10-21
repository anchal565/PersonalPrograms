public class DiameterOfTree2 {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    static int max = Integer.MIN_VALUE;
    public static int diameter(Node node){
        if(node == null)
            return 0;
        if(node != null) {
            int diameter = computeDiameter(node);
            if(max<diameter)
                max = diameter;
            diameter(node.left);
            diameter(node.right);
        }

        return max;
    }

    public static int computeDiameter(Node node){
        int lheight = height(node.left);
        int rheight = height(node.right);
        return lheight+rheight+1;
    }

    private static int height(Node node){
        int lheight =0, rheight =0;
        if(node == null)
            return 0;
        else{
            lheight = 1 + height(node.left);
            rheight = 1 + height(node.right);
        }
        if(lheight >rheight)
            return lheight;
        else
            return rheight;
    }
    public static void main(String[] args) {
        root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int height = diameter(root);
        System.out.println(height);
    }
}
