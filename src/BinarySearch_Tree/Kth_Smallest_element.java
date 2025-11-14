package BinarySearch_Tree;

import Binary_Tree.TreeNode;

public class Kth_Smallest_element {

    public static void main(String[] args) {

        TreeNode  root=new TreeNode(6,new TreeNode(4,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,new TreeNode(8),new TreeNode(16)));

        System.out.println("kth smallest element : "+kthSmallest(root,3));
        System.out.println("kth largest element : "+kthLargest(root,5));



    }

    //Kth Smallest in BST
    static int count=0;
    static int result=0;

    public static  int kthSmallest(TreeNode root, int k) {

        helper(root,k);
        return result;


    }

    public static void helper(TreeNode root,int k){

        if(root==null)return;

        helper(root.left,k);
        count++;

        if(count==k){
            result=root.val;
            return;

        }

        helper(root.right,k);


    }


    //Kth Largest in a BST
    static int countLarge=0;
    static int result1=0;

    public static  int kthLargest(TreeNode root, int k) {

        helper1(root,k);
        return result1;


    }

    public static void helper1(TreeNode root,int k){

        if(root==null)return;


        helper1(root.right,k);
        countLarge++;

        if(countLarge==k){
            result1=root.val;
            return;

        }

        helper1(root.left,k);


    }





}
