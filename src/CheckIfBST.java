/*
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

    //4
    //20 10 L 10 5 L 5 1 L 1 50 R
    static int check = 1;
    public static int isBST(Node root){
        if(root == null)
            return check;

        else{
            if(root.left != null && root.left.data < root.data)
                isBST(root.left);
            else if(root.left != null && root.left.data > root.data) {
                check = 0;
                return check;}
            if(root.right != null && root.right.data > root.data)
                isBST(root.right);
            else if(root.right != null && root.right.data<root.data){
                check = 0;
                return check;}

        }
        return check;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        root = new Node(10);
        root.left = new Node(9);
        //root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.left.right = new Node(30);
        int isBST = isBST(root);
        System.out.println(isBST);

    }
}
*/
