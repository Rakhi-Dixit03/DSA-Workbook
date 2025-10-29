package Binary_Tree;

public class Min_Dist_Nodes {


    static TreeNode prev=null;
    static int minDiff=Integer.MAX_VALUE;


    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        System.out.println(minDiffInBST(root));

    }

    public static  int minDiffInBST(TreeNode root) {

        inOrder(root);
        return minDiff;
    }

    private static void inOrder(TreeNode root){

        if(root == null)return;

        inOrder(root.left);

        if(prev!=null){

            minDiff=Math.min(minDiff,root.val-prev.val);

        }

        //Updating prev for next Node
        prev=root;

        inOrder(root.right);


    }

   // Note : We can also solve it by storing inorder sequence in an array/List and then calculating min difference between adjacent elements of array

}
