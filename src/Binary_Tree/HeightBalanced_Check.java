package Binary_Tree;

public class HeightBalanced_Check {

    static boolean result=true;
    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),null);

        isHeightBalanced(root);
        System.out.println(result);

    }

    public static int isHeightBalanced(TreeNode root){

        if(!result)return 0;//early termination
        if(root==null)return 0;

        int leftHeight=isHeightBalanced(root.left);
        int rightHeight=isHeightBalanced(root.right);

        if(Math.abs(leftHeight-rightHeight)>1)result=false;


        return Math.max(leftHeight,rightHeight)+1;


    }


}
