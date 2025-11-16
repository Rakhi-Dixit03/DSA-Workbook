package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

public class Construct_BST_From_Preorder {

    public static void main(String[] args) {

         int[] pre={8,5,1,7,10,12};

         Construct_BST_From_Preorder obj=new Construct_BST_From_Preorder();
        System.out.println("Constructed Tree's Inorder Sequence using 1st method : ");
        Tree_Traversals.inOrder(obj.bstFromPreorder(pre));
        System.out.println();
        System.out.println("Constructed Tree's Inorder Sequence using 2nd method : ");
        Tree_Traversals.inOrder(obj.bstFromPreOrder(0, pre.length-1, pre));

    }

    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {

        return helper(preorder,Integer.MAX_VALUE);

    }

    TreeNode helper(int[] preorder,int upperBound){

        if(i>=preorder.length || preorder[i]>upperBound){
            return null;

        }//invalid condition

        TreeNode root=new TreeNode(preorder[i++]);

        root.left=helper(preorder,root.val);
        root.right=helper(preorder,upperBound);


        return root;

    }


    //Can also solve with finding start and end of left and right subtrees

    TreeNode bstFromPreOrder(int st,int end,int[] preorder){

        if(st>end)return null;

        if(st==end)return new TreeNode(preorder[st]);

        TreeNode node=new TreeNode(preorder[st]);
        int j=-1;

        for(int i=st;i<=end;i++){

            if(preorder[i]>node.val){
                j=i;
                break;
            }
        }

        node.left=bstFromPreOrder(st+1,j-1,preorder);
        node.right=bstFromPreOrder(j,end,preorder);

        return node;

    }



}
