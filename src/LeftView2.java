import java.util.Scanner;

public class LeftView2 {
    static Node root;
     static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public static void leftViewDriver(Node root){
         leftView(root,false);
    }

    public static void leftView(Node root, boolean check){
        if(root == null)
            return ;
        if(check == false) {
            System.out.println(root.data);
        }

            if (root.left != null)
                leftView(root.left, false);
            else
                leftView(root.right, false);
            if(root.right != null)
                leftView(root.right, true);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //sc.nextLine();
        /*for(int t=0; t<T; t++){
            int n = sc.nextInt();
            for(int i=0;i<n ; i++){
                int n1 = sc.nextInt();
                int n2 =sc.nextInt();
                char direction = sc.next().charAt(0);
                Node node = new Node(n1);
                if(root == null)
                    root = node;
                if(direction == 'L')
                    node.left = new Node(n2);
                else
                    node.right = new Node(n2);
            }

        }*/
         root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.right.left = new Node(5);
         root.right.left.left = new Node(6);
         //root.left.right = new Node(50);
         //root.left.left.right = new Node(60);
        //root.right.right = new Node(40);
         leftViewDriver(root);
    }
}
