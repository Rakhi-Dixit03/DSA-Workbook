package BinarySearch_Tree;

import Binary_Tree.TreeNode;

import java.sql.SQLOutput;


public class LargestBST_In_BT {

    public static void main(String[] args) {


        TreeNode  root=new TreeNode(6,new TreeNode(4,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,new TreeNode(8),new TreeNode(7)));

        System.out.println("Size of Largest BST using Brute Force Approach :  "+largestBST1(root));

        System.out.println("Size of Largest BST using Optimal Approach : "+largestBST2(root).maxSize);



    }

    //Brute Force  TC-O(N*N) SC-O(H)
    private static int largestBST1(TreeNode root){

        if(root==null)return 0;

        if (isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            //If the current node is a valid BST then return the size of entire subtree
            return countNodes(root);

        }

        return Math.max(largestBST1(root.left),largestBST1(root.right));

    }


    //isValidBST method  to check if the tree rooted at a node or given node is a valid BST or Not

    static boolean isValidBST(TreeNode root,int min,int max){

        if(root==null)return true;

        if(root.val<=min || root.val>=max)return false;

        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);


    }

    //Counts the number of nodes in a tree
    static int countNodes(TreeNode root){

        if(root==null)return 0;

        return 1+countNodes(root.left)+countNodes(root.right);

    }


    //Optimal Approach TC-O(N) SC-O(N)

    static NodeValue largestBST2(TreeNode root){

      if(root==null){
          return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
      }


        NodeValue left=largestBST2(root.left);
        NodeValue right=largestBST2(root.right);

        if(root.val>left.maxNode && root.val<right.minNode){//if a valid BST

            //update current node's values based on it's subtrees' values

            return new NodeValue(Math.min(root.val,left.minNode),Math.max(root.val,right.maxNode),
                    1+left.maxSize+ right.maxSize);
        }

       //if not a valid subtree return invalid values
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize));

    }


}


//We have to create a Class NodeValue to keep information for a node(minNode,maxNode,maxSize)
//minNode- keep minimum value of the subtree
//maxNode- keep maximum value of the subtree
//maxSize- keep maximum size of the BST encountered so-far


class NodeValue{


    int minNode;
    int maxNode;
    int maxSize;

    public NodeValue(){}

    public NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }

}


