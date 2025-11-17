package BinarySearch_Tree;

import Binary_Tree.TreeNode;

public class Inorder_Successor {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, new TreeNode(8), new TreeNode(16)));


        Inorder_Successor obj=new Inorder_Successor();


        System.out.println("Inorder Successor is :  "+obj.inorderSuc(root,root.right.left).val);//we are finding successor of 8 ,output is 9

    }

    //Using Structural Property of BST
    TreeNode successor=null;

    private TreeNode inorderSuc(TreeNode root,TreeNode p){

        while(root!=null){

            if( root.val>p.val){

                successor=root;//fist update successor then change root
                root=root.left;

            }else{

               root=root.right;

            }

        }

        return successor;
    }

    //Can Use List to Store values and then returning the next element to the node in the list
    //Can Also use Inorder traversal to find Inorder successor

}
