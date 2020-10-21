//Max distance from one leaf node to another leaf node
public class DiameterOfTree {
    static Node root;
    static int max = Integer.MIN_VALUE;
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public static void recurForEachNode(Node node){
        int count = 0;
        if(node == null)
            return;
        else{
            count = diameterForEachNode(node);
            if(max < count)
                max = count;
            recurForEachNode(node.left);
            recurForEachNode(node.right);
        }

    }

    public static int diameterForEachNode(Node node){
        int lheight = height(node.left);
        int rheight = height(node.right);
        return lheight + rheight + 1;
    }

    public static int height(Node node){
        int lheight =0, rheight =0;
        if(node == null)
            return 0;
        else{
            lheight = 1 + height(node.left);
            rheight = 1 + height(node.right);
        }
        if(lheight > rheight)
            return lheight;
        else
            return rheight;

    }



    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        recurForEachNode(root);
        System.out.println("Maximum diameter is : "+max);


    }
}
