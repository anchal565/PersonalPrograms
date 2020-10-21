public class SumOfRootToLeaf {
    public static int sumRootToLeaf(TreeNode root) {
        //return sumRootToLeafHelper(root, "");
        return sumOfRootToLeafViaInt(root, 0);
    }
    public static int sumRootToLeafHelper(TreeNode root, String path){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null){
            path=path+root.data;
            return Integer.parseInt(path,2);
        }
        return sumRootToLeafHelper(root.left, path+root.data)
                + sumRootToLeafHelper(root.right, path+root.data);
    }

    public static int sumOfRootToLeafViaInt(TreeNode root, int nodeValue){
        if(root == null)
            return 0;
        if(root != null){
            nodeValue = (nodeValue<<1) + root.data;
            System.out.println("CHeck : "+ nodeValue);
        }
        if(root.left == null && root.right == null) {
            return nodeValue;
        }
        return sumOfRootToLeafViaInt(root.left, nodeValue)
                + sumOfRootToLeafViaInt(root.right, nodeValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        int result = sumRootToLeaf(root);
        System.out.println(result);
    }
}
