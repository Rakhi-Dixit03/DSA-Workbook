package BinarySearch_Tree;

import Binary_Tree.TreeNode;
public class Maximum_SumBST_In_BT {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, new TreeNode(11), new TreeNode(16)));
        Maximum_SumBST_In_BT obj=new Maximum_SumBST_In_BT();

        System.out.println("Maximum Sum of BST in BT : "+obj.maxSumBST(root));

    }


    int maxSum = 0;

    public int maxSumBST(TreeNode root) {

        helper(root);
        return maxSum;
    }

   private Data helper(TreeNode root) {

        if (root == null)
            return new Data(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        //first process Children

        Data left = helper(root.left);
        Data right = helper(root.right);

        //if valid BST

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            //update curr node's values
            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, sum);

            return new Data(sum, Math.min(root.val, left.min),
                    Math.max(root.val, right.max), true);

        }
        //invalid BST ,so parent cannot treat it as BST
        return new Data(0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);

    }

    static class Data {
        int sum;
        int min;
        int max;
        boolean isBST;

        public Data(int sum, int min, int max, boolean isBST) {
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.isBST = isBST;

        }

    }



}
