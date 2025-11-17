package BinarySearch_Tree;

import Binary_Tree.TreeNode;

public class Inorder_Predecessor {

    public static void main(String[] args) {

        Inorder_Predecessor obj=new Inorder_Predecessor();

        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, new TreeNode(8), new TreeNode(16)));

        System.out.println("Inorder Predecessor of node is : "+obj.inorderPredecessor(root,root.right.left).val);

    }

    //Recursive Solution

    TreeNode predecessor=null;
    private TreeNode inorderPredecessor(TreeNode root,TreeNode p){

         if(root==null)return null;

         if(root.val <p.val){

             predecessor=root;
             inorderPredecessor(root.right,p);//going to right to search for bigger values

         }else{

              inorderPredecessor(root.left,p);
         }

        return predecessor;

    }


}
