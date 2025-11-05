package Binary_Tree;

public class BT_To_FlattenLL {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));

        flatten(root);
        printLL(root);


    }

    static TreeNode nextRight=null;
    public static void flatten(TreeNode root) {

        if(root== null)return;

        flatten(root.right);
        flatten(root.left);

        root.left=null;
        root.right=nextRight;
        nextRight=root;

    }

    static void  printLL(TreeNode head){

        while(head!=null){

            System.out.print(head.val+" ");
            head=head.right;

        }


    }



}
