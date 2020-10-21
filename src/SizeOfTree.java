// Compute size, max and min of a tree

public class SizeOfTree {
    static int counter = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public int size(Node node){
        if(node == null)
            return 0;
        else{
            counter = counter + 1;
            System.out.println(node.data);
            size(node.left);
            size(node.right);
        }
        return counter;
    }

    public int max(Node node){
        if(node == null)
            return 0;
        else{
            if(max < node.data)
                max = node.data;
            max(node.left);
            max(node.right);
            return max;
        }
    }

    public int min(Node node){
        if(node == null)
            return 0;
        else{
            if(min > node.data)
                min = node.data;
            min(node.left);
            min(node.right);
            return min;
        }

    }

    public static void main(String[] ar){
        SizeOfTree classObj = new SizeOfTree();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(7);
        root.left.left.right = new Node(9);
        System.out.println("Size of tree is : " + classObj.size(root));
        System.out.println("Max of tree is : "+ classObj.max(root));
        System.out.println("Min of tree is : "+ classObj.min(root));
    }
}
