public class SameTree {
    static class Node{
        int val;
        Node left, right;
        Node(int d){
            val = d;
            left = right = null;
        }
    }

    public static boolean isSameTree(Node p, Node q) {
        if(p==null && q==null){
            return true;
        }
        else if((p==null) ^ (q==null))
            return false;
        if(p.val == q.val){
            if(isSameTree(p.left, q.left))
                return isSameTree(p.right, q.right);
            else
                return false;
        }
        else{
            return false;
        }
    }

    public static boolean isSameTree2(Node p, Node q) {
        if(p==null && q==null){
            return true;
        }
        else if(p!=null && q!=null){
            return ((p.val==q.val) && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right));
        }
        else
            return false;
    }


    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(4);
        root1.right = new Node(3);
        Node root2 = new Node(1);
        root2.left = new Node(4);
        root2.right = new Node(5);
        boolean result = isSameTree2(root1, root2);
        System.out.println(result);
    }
}
