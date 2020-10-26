public class BinaryTreeToDLL {
    static Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public static Node addInDLL(int data){
        Node new_node = new Node(data);
        if(head == null)
            head = new_node;
        else{
            Node temp_node = head;
            while (temp_node.right != null){
                temp_node = temp_node.right;
            }
            temp_node.right = new_node;
            new_node.left = temp_node;
        }
        return head;
    }

    public static void printDLL(Node head){
        Node temp_node = head;
        Node temp = null;
        while (temp_node != null){
            System.out.print(temp_node.data + " ");
            temp = temp_node;
            temp_node = temp_node.right;
        }
        System.out.println();
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.left;
        }
        System.out.println();
    }


    public static void bToDLL(Node root){
        root = preOrder(root);
        printDLL(root);
    }
    static Node head = null;
    public static Node preOrder(Node root){
        if(root == null)
            return head;
        else{
            preOrder(root.left);
            addInDLL(root.data);
            preOrder(root.right);
        }
        return head;
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(20);
        root.left.left = new Node(5);
        root.right.right = new Node(15);
        root.right.right.left = new Node(25);
        root.left.left.right = new Node(4);
        bToDLL(root);
    }
}

