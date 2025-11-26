package BinarySearch_Tree;

import Binary_Tree.TreeNode;

public class Range_SumBST {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, new TreeNode(8), new TreeNode(16)));

        System.out.println("Range Sum is : "+rangeSumBST(root,4,8));


    }

    public static int rangeSumBST(TreeNode root, int low, int high) {

        if(root==null)return 0;//sum of a null node will be 0

        //if root value is less than range go to right because all values in its left subtree will be less
        if(root.val<low){

            return rangeSumBST(root.right,low,high);

        }else if(root.val>high){ //if root value is greater than range go to left

            return rangeSumBST(root.left,low,high);

        }

        //if root value lies within the range

        int left=rangeSumBST(root.left,low,high);//get sum of all nodes in its left subtree
        int right=rangeSumBST(root.right,low,high);//get sum of all nodes in its right subtree

        return root.val+left+right;


    }
}

