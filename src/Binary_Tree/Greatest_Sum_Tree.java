package Binary_Tree;

import java.util.ArrayList;
import java.util.List;


//Transform a BST to  Greatest Sum Tree
public class Greatest_Sum_Tree {

    static List<Integer> list =new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(6,new TreeNode(5),null));

        Tree_Traversals.preOrder(bstToGst1(root));


    }


   //Using Inorder generated sorted List O(N^2)

    public static TreeNode bstToGst(TreeNode root) {

        inOrder(root);

        helper(root);

        return root;

    }


    private static void inOrder(TreeNode root){

        if(root==null)return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

    }

    private static void helper(TreeNode root){

        if(root==null)return;


        int val=root.val;
        int sum=0;
        for(int i=list.size()-1;i>=0;i--){

            if(list.get(i)>=val){

                sum+=list.get(i);
            }
        }

        root.val=sum;

        //Call for left subtree

        helper(root.left);
        //Call for right subtree
        helper(root.right);

    }


//Optimised Approach O(N)
    static int sum=0;

    public static TreeNode bstToGst1(TreeNode root) {

        if(root==null)return null;

        bstToGst1(root.right);

        sum+=root.val;
        root.val=sum;

        bstToGst1(root.left);

        return root;

    }


}
