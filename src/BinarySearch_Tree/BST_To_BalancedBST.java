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

    //----------------------------

    //Can Also Do this way,just manipulating the pointers


    int n;
    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {

        inOrder(root);
        n = list.size();//Number of nodes in the BST

        //Got the Sorted List, after it, we can Build our Balanced BST out of this Sorted list
        return helper(0, n - 1);

    }


    private void inOrder(TreeNode root) {

        //Base Case
        if (root == null)
            return;

        inOrder(root.left);
        //Processing the root
        list.add(root);
        inOrder(root.right);

    }


    private TreeNode helper(int l, int h) {

        if (l > h) {//it means that we don't have more nodes
            return null;
        }

        int mid = l + (h - l) / 2;

        TreeNode root = list.get(mid);
        root.left = helper(l, mid - 1);
        root.right = helper(mid + 1, h);

        return root;

    }


}
