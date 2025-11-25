package Binary_Tree;

public class UniValuedTree {

    public static void main(String[] args) {

       TreeNode root=new TreeNode(1,new TreeNode(1,new TreeNode(1),new TreeNode(1)),
               new TreeNode(1,new TreeNode(2),null));

        System.out.println(isUnivalTree(root));

    }

    public static boolean isUnivalTree(TreeNode root) {

        if(root==null)return true;

        if(root.left!=null && root.val!=root.left.val){
            return false;
        }

        if(root.right!=null && root.val!=root.right.val){
            return false;
        }

        return isUnivalTree(root.left)&& isUnivalTree(root.right);

    }


}
