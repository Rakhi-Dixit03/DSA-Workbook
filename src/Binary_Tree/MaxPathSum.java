package Binary_Tree;

public class MaxPathSum {

    public static void main(String[] args) {

        MaxPathSum obj = new MaxPathSum();

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4),
                new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

        System.out.println(obj.maxPathSum(root));


    }


    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root==null)return 0;

        helper(root);

        return maxSum;

    }


    int helper(TreeNode root){

        if(root==null)return 0;

        int leftSum=Math.max(helper(root.left),0);

        int rightSum=Math.max(helper(root.right),0);//Avoiding negative values

        maxSum=Math.max(maxSum,(root.val+leftSum+rightSum));


        return root.val+Math.max(leftSum,rightSum);


    }


}
