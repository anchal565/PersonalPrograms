
import java.util.Scanner;

public class CheckIfBST {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    //IN O(n2)
    /*static int max;
    static int min;
    static int flag;
    public static int isBST(Node root){
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        if(root == null) {
            flag = 1;
            return flag;
        }
        else {
            if(maxMethod(root.left) < root.data && minMethod(root.right) > root.data){
                if(isBST(root.left) == 1)
                    return isBST(root.right);
                else
                    flag = 0;
            }
            flag = 0;

        }
        return flag;
    }

    public static int maxMethod(Node node){
        if(node == null)
            return max;
        else{
            if(max < node.data)
                max = node.data;
            maxMethod(node.left);
            maxMethod(node.right);
        }
        return max;
    }

    public static int minMethod(Node node){
        if(node == null)
            return min;
        else {
            if(min > node.data)
                min = node.data;
            minMethod(node.left);
            minMethod(node.right);
        }
        return min;
    }*/



    //IN O(n)
    public static int isBST(Node root){
        return isBSTPerNode(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static int isBSTPerNode(Node root, int max, int min){
        if(root == null)
            return 1;
        else {
            if(root.data>min && root.data < max) {
                return isBSTPerNode(root.left, root.data, min) & isBSTPerNode(root.right, max, root.data);

            }
            else
                return 0;
        }

    }

    //4
    //20 10 L 10 5 L 5 1 L 1 50 R

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        root = new Node(10);
        //root.left = new Node(7);
        root.right = new Node(20);
        //root.left.left = new Node(5);
        root.right.right = new Node(15);
        //root.right.right.left = new Node(25);
        //root.left.left.right = new Node(4);
        int isBST = isBST(root);
        System.out.println(isBST);

    }
}

