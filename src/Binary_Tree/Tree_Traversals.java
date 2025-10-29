package Binary_Tree;

public class Tree_Traversals {


    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);


    }
    public static void  preOrder(TreeNode root ){

         //Base Case
        if(root==null)return;

        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    private static void inOrder(TreeNode root){

        //Base Case
        if(root==null)return;

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);

    }

    private static void postOrder(TreeNode root){

        //Base Case

        if(root==null)return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");

    }


}
