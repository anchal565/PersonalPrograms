public class HeightBalancedTree {
    static Node root;
    static int max = 0;
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static boolean flag = true;
    public static boolean recurForAllNodes(Node node){
        flag = true;

        if(node == null)
            return flag;
        if(flag == false)
            return false;
        else {
            flag = isBalanced(node);
            if(flag == true)
                recurForAllNodes(node.left);
            if(flag == true)
                recurForAllNodes(node.right);

        }
        return flag;
    }

    public static boolean isBalanced(Node node){
        int lheight =0, rheight =0;
        if(node == null)
            return true;
        if(node.left != null)
            lheight = heightBalanced(node.left);
        if(node.right != null)
            rheight = heightBalanced(node.right);
        if(Math.abs(lheight - rheight) == 1 || Math.abs(lheight - rheight) ==0)
            return true;
        else
            return false;
    }

    public static int heightBalanced(Node node){
        int lheight, rheight =0;
        if(node == null){
            return 0;
        }
        else{
           lheight = 1+ heightBalanced(node.left);
           rheight = 1+ heightBalanced(node.right);
        }
        if(lheight > rheight)
            return lheight;
        else
            return rheight;
    }
    public static void main(String[] args) {
        root = new Node(1);
        /*root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(6);
        root.right.right = new Node(5);*/
        /*int lheight = heightBalanced(root.left);
        int rheight = heightBalanced(root.right);
        if(Math.abs(lheight - rheight) == 1 || Math.abs(lheight - rheight) ==0)
            System.out.println("Height balanced tree");
        else{
            System.out.println("Not a balanced tree");
        }*/
        boolean check = recurForAllNodes(root);
        System.out.println("Flag is : "+check);
    }
}
