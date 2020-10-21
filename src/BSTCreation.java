public class BSTCreation {
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    BSTCreation(){
        root = null;
    }

    public static Node createTree(int key, Node node){
        if(root == null)
            return (new Node(key));
        if(node == null)
            return (new Node(key));
        if(key == node.data)
            return root;
        else{
            if(key < node.data)
                node.left = createTree(key, node.left);
            else
                node.right = createTree(key , node.right);
        }
        return node;
    }

    public static boolean searchTree(int key, Node node){
        if(node == null)
            return false;
        if(node.data == key)
            return true;

        else{
            if(key <= node.data)
                    return searchTree(key, node.left);
            else
                return searchTree(key, node.right);
        }

    }

    public static void deleteNode(int key, Node node){
        
    }

    /*public static Node deleteNode(int key, Node node){
        if(node == null)
            return node;
        if(node.data == key){
            node = null;
            return node;
        }
        else{
            if(key < node.data)
                deleteNode(key, node.left);
            else
                deleteNode(key, node.right);
        }
    }*/

    public static void preOrder(Node node){
        if(node == null)
            return;
       // else{
            System.out.print(node.data+" ");
            preOrder(node.left);
            preOrder(node.right);
        //}
    }

    public static void main(String[] args) {
        BSTCreation treeObj = new BSTCreation();

        root = createTree(84, root);
        root= createTree(87, root);
        root=createTree(43, root);
        root=createTree(92, root);
        root = createTree(19,root);
        root=createTree(37, root);
        root=createTree(3, root);
        root=createTree(1, root);
        root=createTree(20, root);
        root=createTree(84, root);
        preOrder(root);
        boolean searchFlag = searchTree(92, root);
        System.out.println("Search key is : "+searchFlag);

       // deleteNode(92, root);
        searchFlag = searchTree(92, root);
        System.out.println("Search key is : "+searchFlag);

    }
}
