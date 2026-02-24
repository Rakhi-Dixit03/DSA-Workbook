package Bit_Manipulation;

import Binary_Tree.TreeNode;

public class Sum_Root_To_Leaf_Binary_Numbers {

    int finalAns = 0;

    //TC-O(N) SC-(H)-height of binary tree
    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return finalAns;
    }

    private void helper(TreeNode root, int curr) {

        if (root == null) {
            return;

        }

        curr = (curr << 1) | root.val;

        if (root.left == null && root.right == null) {
            finalAns += curr;
            return;
        }
        helper(root.left, curr);
        helper(root.right, curr);

    }

}
