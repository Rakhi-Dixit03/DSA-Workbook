package Binary_Tree;

//Lowest Common Ancestor

public class LCA {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(4,new TreeNode(2),new TreeNode(1));

        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(5);
        root.right.left=new TreeNode(7);

        TreeNode newRoot=lowestCommonAncestor(root,root.right.right,root.right.left);//5 and 7

        System.out.println("Lowest common Ancestor is "+newRoot.val);


    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);


        if (leftN != null && rightN != null) {
            return root;
        }


        return leftN != null ? leftN : rightN;


    }
}