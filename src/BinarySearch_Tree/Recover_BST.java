package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

public class Recover_BST {

    public static void main(String[] args) {

       TreeNode root=new TreeNode(1,new TreeNode(3,null,new TreeNode(2)),null);

        Recover_BST obj=new Recover_BST();
        System.out.println("Inorder Traversal before Recovering Tree : ");
        Tree_Traversals.inOrder(root);

        System.out.println();
        //Calling Recover Method
        obj.recoverTree(root);

        System.out.println("Inorder Traversal After Recovering Tree : ");
        Tree_Traversals.inOrder(root);

    }

    TreeNode prev=null;
    TreeNode first=null;
    TreeNode second=null;

    public  void recoverTree(TreeNode root) {

        // we can Use Inorder Traversal with slight modification

        if(root==null)return;
        helper(root);

        int temp=first.val;
        first.val=second.val;
        second.val=temp;

    }

    void helper(TreeNode root){

        if(root==null)return;

        helper(root.left);

        if(prev!=null && root.val<prev.val ){

            if(first==null){
                first=prev;
            }

            second=root;

        }

        prev=root;

        helper(root.right);

    }


}
