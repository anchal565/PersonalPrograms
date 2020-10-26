public class MirrorOfTree {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    static boolean flag = true;
    public static boolean isSymmetric(Node root){
        if(root == null)
            return flag;
        else {
            isSymmetricCheck(root, root);
            return flag;
        }

    }

    public static boolean isSymmetricCheck(Node first, Node second){
        if(first == null && second != null) {
            flag = false;
            return flag;
        }
        else if(first != null && second == null){
            flag = false;
            return  flag;
        }
        else if(first == null && second == null)
            return flag;
        else {
            if(first.data == second.data){
                isSymmetricCheck(first.left, second.right);
                isSymmetricCheck(first.right,second.left);
            }
            else {
                flag = false;
                return flag;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.right.right = new Node(4);
        isSymmetric(root);
        System.out.println(flag);
    }
}
