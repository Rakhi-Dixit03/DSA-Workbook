package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

public class SortedArray_To_BalancedBST {


    public static void main(String[] args) {

        int[] nums={-10,-3,0,5,9};

        SortedArray_To_BalancedBST obj=new SortedArray_To_BalancedBST();

         Tree_Traversals.preOrder(  obj.sortedArrayToBST(nums));


    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return createTree(nums,0,nums.length-1);

    }

    private TreeNode createTree(int[] nums,int low,int hi){

        if(low>hi){
            return null;
        }

        int mid=low+(hi-low)/2;

        TreeNode root=new TreeNode(nums[mid]);

        root.left=createTree(nums,low,mid-1);
        root.right=createTree(nums,mid+1,hi);

        return root;

    }

}
