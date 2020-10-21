import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/explore/featured/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3417/
public class SumExistInTree {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        /*Queue<Integer> queue = new LinkedList<>();
        noOfPaths(root, sum, 0, queue);
        return count;*/
        path(root, new ArrayList<Integer>(), sum);

        return count;
    }

    public void path(TreeNode root, List<Integer> previousList, int sum){
        if(root == null)
            return ;
        List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < previousList.size(); i++) {
                int tempSum = previousList.get(i);
                currList.add(tempSum + root.data);
            }
        currList.add(root.data);
        for(Integer currValues : currList){
            if(currValues == sum)
                count++;
        }
        path(root.left, currList, sum);
        path(root.right, currList, sum);
    }
    public void noOfPaths(TreeNode root, int sum, int tempSum, Queue<Integer> queue){
        if(root == null)
            return;
        if(tempSum + root.data > sum){
            if(!queue.isEmpty()) {
                tempSum = tempSum + root.data - queue.poll();
                queue.add(root.data);
            }
            else{
                tempSum = root.data;
                queue.add(root.data);
            }
        }
        else if(tempSum + root.data <= sum){
            tempSum += root.data;
            queue.add(root.data);
        }
        if(tempSum == sum){
            count++;
            tempSum = root.data;
            queue.poll();
        }
        noOfPaths(root.left, sum, tempSum, queue);
        noOfPaths(root.right, sum, tempSum, queue);
    }

    public static void main(String[] args) {
        SumExistInTree sumExistInTree = new SumExistInTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        sumExistInTree.pathSum(root, 8);
        System.out.println(sumExistInTree.count);
    }
}
