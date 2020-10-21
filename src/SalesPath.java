import java.io.*;
import java.util.*;

//https://codeinterview.io/GCHCTEJDTX

class Solution {

    static int min=Integer.MAX_VALUE;
    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }


    public static void main(String[] args) {
        SalesPath salesPath = new SalesPath();

        int[][] a=new int[4][];
        int x =a.length;
        //Node rootNode = new Node(0);
    /*List<Node> listChild = new ArrayList<>();
    listChild.add(new Node(5));
    listChild.add(new Node(3));
    listChild.add(new Node(6));
    rootNode.children = */

        Node rootNode = new Node(1);
        Node node5 = new Node(3);
        node5.parent = rootNode;
        Node node3 = new Node(6);
        node3.parent = rootNode;
        Node node6 = new Node(2);
        node6.parent = rootNode;
        rootNode.children = new Node[] {node5, node3, node6};

        //rootNode.children={new Node(5), new Node(3), new Node(6)};
        int result = salesPath.getCheapestCost(rootNode);
        System.out.println(result);
    }

    static class SalesPath {

        int getCheapestCost(Node rootNode) {
            // your code goes here
            //int result = getResult(rootNode,0, false);
            int result=0;
            if(rootNode == null)
                return 0;
            else {
                result = getResult(rootNode, rootNode.cost);
            }
            return result;

        }


        static int getResult(Node rootNode, int sum){

            if(rootNode.children == null){
                if(min > sum)
                    min=sum;
                return min;
            }

            else{

                    for(Node a : rootNode.children)
                        getResult(a, sum+a.cost);
              }
            return min;

        }
    }

}
