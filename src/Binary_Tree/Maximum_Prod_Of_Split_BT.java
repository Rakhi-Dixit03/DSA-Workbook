package Binary_Tree;

public class Maximum_Prod_Of_Split_BT {

    //Pattern - DFS + Subtree Sum
    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));

        Maximum_Prod_Of_Split_BT obj=new Maximum_Prod_Of_Split_BT();
        System.out.println("Maximum Product of Split Binary Tree is : "+obj.maxProduct(root));


    }

    private static final int M=1000000007;
    private long maxProd=0;
    private long total;

    public int maxProduct(TreeNode root) {

        //Can compute the total sum by using [helper] only, just for clarity I have separated the code to two

        total=getSum(root);//First DFS to compute totalSum

        helper(root);//Second DFS (postorder) to compute subtree sums



        return (int)(maxProd%M);

    }

    private long helper(TreeNode root){

        if(root==null)return 0;

        long leftSum=helper(root.left);
        long rightSum=helper(root.right);

        long subtreeSum=leftSum+rightSum+root.val;

        maxProd=Math.max(maxProd,(total-subtreeSum)*subtreeSum);//For each subtree, update max product
        return subtreeSum;

    }

     private long getSum(TreeNode root){

        if(root==null)return 0;

        long leftSum=helper(root.left);
        long rightSum=helper(root.right);

        return leftSum+rightSum+root.val;

     }


}
