package BinarySearch_Tree;

import Binary_Tree.TreeNode;

import java.util.Stack;

public class Closest_Node_in_BST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, new TreeNode(8), new TreeNode(16)));

        closestNode(root,10);
        System.out.println("Closest Node is : "+closeNode.val);

    }


   static int minDiff=Integer.MAX_VALUE;
    static TreeNode closeNode;
    public static void closestNode(TreeNode root,int k){//we have to find the closest node to integer k

        if(root==null)return ;

        if(k==root.val){
           closeNode=root;
           return;
        }

        if(minDiff>Math.abs(root.val-k)){
            minDiff=Math.min(minDiff,Math.abs(root.val-k));
            closeNode=root;
        }

        if(k< root.val){//go to left
            closestNode(root.left,k);
        }else{//go to right
             closestNode(root.right,k);
        }

    }

}
