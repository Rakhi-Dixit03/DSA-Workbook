package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

public class Validate_BST {


    public static void main(String[] args) {

        TreeNode  root=new TreeNode(6,new TreeNode(4,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,new TreeNode(8),new TreeNode(16)));


        Validate_BST obj=new Validate_BST();

        System.out.println("Is it a Valid BST : "+obj.isValidBST(root));


    }

    long min=Long.MIN_VALUE;
    long max=Long.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {

        if(root==null)return true;
        return helper(root,min,max);

    }

    private boolean helper(TreeNode root,long min,long max){

        if(root==null)return true;

        if((root.val<=min) || (root.val>= max))return false;


        return helper(root.left,min,root.val) && helper(root.right,root.val,max);


    }

}
