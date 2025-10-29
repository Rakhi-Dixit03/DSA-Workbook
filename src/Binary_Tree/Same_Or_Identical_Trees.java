package Binary_Tree;

public class Same_Or_Identical_Trees {

    //Two trees are identical or same if they both have same structure and same nodes values

    public static void main(String[] args) {

        TreeNode root1=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(6));

        TreeNode root2=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(6));

        System.out.println(isSameTree(root1,root2));

    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {

        return helper(p,q);

    }

    public static boolean helper(TreeNode p,TreeNode q){

        //if both are null

        if(p==null && q==null)return true;

        //if one of them is null
        if(p==null || q==null)return false;
        //if values are not same
        if(p.val!=q.val)return false;

        //check left and right subtrees of both trees recursively

        return helper(p.left,q.left)&& helper(p.right,q.right);


    }



}
