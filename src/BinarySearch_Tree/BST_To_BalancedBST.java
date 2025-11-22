package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

import java.util.ArrayList;
import java.util.List;

//Same concept as like Sorted List to Balanced BST
public class BST_To_BalancedBST {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(8,new TreeNode(6),new TreeNode(10));
        root.left.left=new TreeNode(5,new TreeNode(3),null);

        root.right.right=new TreeNode(11,null,new TreeNode(12));

        /*       8
        *      /   \
        *     6     10
        *    /       \
        *   5         11
        *  /           \
        * 3            12
        *
        *  unbalanced Tree
        *
        * */

        System.out.println("Preorder of unbalanced Tree : ");
        Tree_Traversals.preOrder(root);

        System.out.println();

       BST_To_BalancedBST obj=new BST_To_BalancedBST();

       System.out.println("Preorder of balanced Tree : ");
       Tree_Traversals.preOrder(obj.balancedBST(root));


    }


    public TreeNode balancedBST(TreeNode root){

        List<Integer> list=new ArrayList<>();

        inorder(root,list);

        return buildTree(list,0,list.size()-1);

    }


    public void inorder(TreeNode root,List<Integer>list){

        if(root==null)return;

        inorder(root.left,list);

        list.add(root.val);

        inorder(root.right,list);

    }

    public TreeNode buildTree(List<Integer>list,int st,int end){

        if(st>end)return null;

        int mid=st+(end-st)/2;

        TreeNode root=new TreeNode(list.get(mid));

        root.left=buildTree(list,st,mid-1);
        root.right=buildTree(list,mid+1,end);


        return root;

    }
}
