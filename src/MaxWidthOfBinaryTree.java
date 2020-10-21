//https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/
//Not working. Refer solution 2 & 3
public class MaxWidthOfBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        int height = height(root);
        int width = -1;
        for(int i=0; i<height; i++){
            int localWidth = 0;
            int smallest =Integer.MAX_VALUE, largest=Integer.MIN_VALUE;
            String path = "";
            path = widthPerLevel(root, i, path, false, smallest, largest);
            int decimalV = convertToNodeValueFromBinary(path);
            if(decimalV < smallest)
                smallest = decimalV;
            if(decimalV > largest)
                largest = decimalV;
            localWidth = largest-smallest + 1;
            if(width < localWidth)
                width = localWidth;
        }
        return width;
    }

    public static int convertToNodeValueFromBinary(String path){
        return Integer.parseInt(path, 2);
    }

    public static String widthPerLevel(TreeNode root, int level, String path, boolean leftChild, int smallest, int largest){
        if(root == null)
            return null;
        if(level == 0){
            path = path+ ((leftChild==false)?1:0);

        }
        else{
            widthPerLevel(root.left, level-1, path, true, smallest, largest);
            widthPerLevel(root.right, level-1, path, false, smallest, largest);
        }
        return path;
    }

    public static int height(TreeNode root){
        int lheight=0, rheight=0;
        if(root == null)
            return 0;
        lheight = 1+height(root.left);
        rheight = 1+height(root.right);
        return (lheight>rheight ? lheight : rheight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        int width = widthOfBinaryTree(root);
        System.out.println(width);
    }
}
