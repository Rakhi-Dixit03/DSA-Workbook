package Binary_Tree;


public class Diameter_Of_Tree {

    static int result=0;
    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));

        diameter(root);
        System.out.println(result);


    }

    public static int diameter(TreeNode root){

        if(root==null)return 0;

        int leftDiam=diameter(root.left);
        int rightDiam=diameter(root.right);

        result=Math.max(result,rightDiam+leftDiam);//finding answer considering curr node (means diam passing through curr node)

        return Math.max(leftDiam,rightDiam)+1;//passing best answer to the node above the curr node


    }

}
