//Given a Binary Tree, Print the corner nodes at each level

import java.util.LinkedList;
import java.util.Queue;

public class LeftMostAndRightMostNodeInTree {
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void levelOrderTraversalUsingQueue(Node node){
        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()){
            Node tempNode = queue.peek();
            /*if(flag == true)
                System.out.print(tempNode.data + " ");
            flag = false;*/
            //Node tempNode = queue.poll();
            for(Node iterator : queue){
                if(iterator == null)
                    break;
                else{
                    if (iterator.left != null)
                        queue.add(node.left);
                    if (iterator.right != null)
                        queue.add(node.right);
                }

            }
            /*while(queue.peek() != null) {
                if (tempNode.left != null)
                    queue.add(node.left);
                if (tempNode.right != null)
                    queue.add(node.right);
            }*/

            queue.add(null);
            while(queue.peek() == null)
                queue.poll();
                //flag=true;



        }
        System.out.println("Queue formed is : ");
        for(Node nodeToPrint : queue){
            System.out.print(nodeToPrint.data + " ");
        }
    }

    public static void main(String[] args) {
        root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        levelOrderTraversalUsingQueue(root);

    }
}
