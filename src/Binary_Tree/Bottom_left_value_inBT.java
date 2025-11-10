package Binary_Tree;

public class Bottom_left_value_inBT {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7,null,new TreeNode(8))));

        Bottom_left_value_inBT obj=new Bottom_left_value_inBT();

        System.out.println("Bottom Left value is : "+obj.findBottomLeftValue(root));


    }

    public  int findBottomLeftValue(TreeNode root) {

        if(root==null)return 0;
        helper(root,0);
        return res;


    }

    int last=0;
    int res=0;

    private void helper(TreeNode root,int curr){

        if(root==null)return;

        if(curr==last){

            res=root.val;
            last++;

        }

        helper(root.left,curr+1);
        helper(root.right,curr+1);


    }
   //Can Solve with simple BFS as well just store the first value in the queue as potential answer at each new level

}
