import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/
public class MaxWidthOfBT2 {

    public static int widthOfBinaryTree(TreeNode root){
        long width = 0;
        int height = height(root);
        for(int i=0; i<height; i++){
            List<Integer> check = new ArrayList<>();
            check.add(0, Integer.MAX_VALUE);
            check.add(1, Integer.MIN_VALUE);
            List<Integer> pairAtGivenLevel = pairAtGivenLevel(root, i, 0, check);
            long tempWidth = pairAtGivenLevel.get(1) - pairAtGivenLevel.get(0) + 1;
            if(width < tempWidth)
                width = tempWidth;
        }
        return (int) width;
    }

    public static List<Integer> pairAtGivenLevel(TreeNode root, int level, int index, List<Integer> pairAtGivenLevel){
        if(root == null)
            return pairAtGivenLevel;
        if(level == 0){
            if(pairAtGivenLevel.get(0) > index)
                pairAtGivenLevel.set(0, index);
            if(pairAtGivenLevel.get(1) < index)
                pairAtGivenLevel.set(1, index);
        }
        else {
            pairAtGivenLevel(root.left, level-1, 2*index, pairAtGivenLevel);
            pairAtGivenLevel(root.right, level-1, 2*index +1, pairAtGivenLevel);
        }
        return pairAtGivenLevel;
    }

    public static int height(TreeNode root){
        int lheight=0, rheight = 0;
        if(root == null)
            return 0;
        lheight = 1+height(root.left);
        rheight = 1+height(root.right);
        return lheight>rheight ? lheight:rheight;
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
