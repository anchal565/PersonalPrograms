public class IfTwoTreesIdentical {
    static Node root1, root2;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
        }
    }

    public static boolean isIdentical(Node root1, Node root2){
        //boolean flag = true;
        if(root1 == null && root2 == null)
            return true;
        if(root1== null && root2!= null)
            return false;
        if(root1!= null && root2== null)
            return false;
        if(root1.data != root2.data)
            return false;
        else {
                return isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
        }

    }

    public static void main(String[] args) {
        root1 = new Node(20);
        root1.left = new Node(8);
        root1.right = new Node(22);
        root1.left.left = new Node(4);
        root1.left.right = new Node(12);
        root1.left.right.left = new Node(10);
        root1.left.right.right = new Node(14);

        root2 = new Node(20);
        root2.left = new Node(8);
        root2.right = new Node(22);
        root2.left.left = new Node(4);
        root2.left.right = new Node(12);
        root2.left.right.left = new Node(10);
        //root2.left.right.right = new Node(14);

        boolean flag = isIdentical(root1,root2);
        System.out.println(flag);
        /*root.right.right = new Node(7);
        root.right.right.right = new Node(8);*/
    }
}
