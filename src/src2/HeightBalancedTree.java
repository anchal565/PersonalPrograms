public class HeightBalancedTree {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    static boolean flag = false;
    public static boolean isBalanced(Node node){
        flag = false;
        if(node == null)
            return true;
        else{
            flag = isBalancedPerNode(node);
            if(flag == true){
                flag = isBalanced(node.left);
                if(flag == true)
                    flag = isBalanced(node.right);
                else
                    return flag;
            }
            else
                return flag;
        }
        return flag;
    }

    public static boolean isBalancedPerNode(Node node){
        int lheight = height(node.left);
        int rheight = height(node.right);
        if(Math.abs(lheight - rheight) >1)
            return false;
        else
            return true;
    }

    private static int height(Node node){
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
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.right = new Node(3);
        root.right.right = new Node(4);
        isBalanced(root);
        System.out.println(flag);
    }
}
