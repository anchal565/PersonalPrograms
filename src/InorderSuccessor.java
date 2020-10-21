/*
public class InorderSuccessor {
    static Node root;
    static int min=Integer.MAX_VALUE;
    static boolean flag = false;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void inOrderSuccessor(Node root, Node node){
        if(node == null)
            return ;
        if(node.data == key) {
            flag = true;
            if (node.right == null)
                return;
            else {
                minValueInTheTree(node.right);
            }
        }
        else {
            inOrderSuccessor(key, node.left);
            if(flag == false)
                inOrderSuccessor(key, node.right);
        }

    }

    public static void successor(Node node, int key){

    }

    public static int minValueInTheTree(Node node){
        if(node == null)
            return min;
        if(min>node.data){
            min = node.data;
        }
        minValueInTheTree(node.left);
        minValueInTheTree(node.right);
        return min;
    }

    */
/*public static void inOrderSuccessor(int key, Node node){
        if(node == null)
            return;
        if(key == node.data)

        inOrderSuccessor(key,node.left);
        inOrderSuccessor(key, node.right);
    }*//*


    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        root.left.right.left = new Node(6);
        root.left.right.left.left = new Node(5);
        root.left.right.left.right = new Node(7);
        root.right.left = new Node(11);
        root.right.right = new Node(15);
        inOrderSuccessor(root.left, root);
        System.out.println("Min is : "+min);
    }
}

*/
