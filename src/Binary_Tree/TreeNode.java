package Binary_Tree;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){

    }

    public TreeNode(int val){
        this.val=val;
        this.left=this.right=null;
    }

    public TreeNode(int val,TreeNode left,TreeNode right ){
        this.val=val;
        this.left=left;
        this.right=right;
    }

}
