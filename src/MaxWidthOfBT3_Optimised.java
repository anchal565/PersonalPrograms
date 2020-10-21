import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/
public class MaxWidthOfBT3_Optimised {
    public static int widthOfBinaryTree(TreeNode root){
        List<List<Integer>> listAtAllLevels = new ArrayList<>();
        widthAtLevels(root, 0, 0, listAtAllLevels);
        int width = Integer.MIN_VALUE;
        for(List<Integer> subList : listAtAllLevels){
            int tempWidth = Math.abs(subList.get(1)-subList.get(0)) + 1;
            width = Math.max(tempWidth, width);
        }
        return width;
    }

    public static void widthAtLevels(TreeNode root, int level, int distance, List<List<Integer>> finalList){
        if(root == null)
            return ;
        if(finalList.size() <= level){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(distance);
            tempList.add(distance);
            finalList.add(level, tempList);
        }
        else {
            List<Integer> tempList = finalList.get(level);
            if(tempList.get(0) > distance)
                tempList.set(0, distance);
            if(tempList.get(1) < distance)
                tempList.set(1, distance);
        }
        widthAtLevels(root.left, level+1, 2*distance, finalList);
        widthAtLevels(root.right, level+1, 2*distance + 1, finalList);
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
