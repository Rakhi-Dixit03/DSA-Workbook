package Binary_Tree;

public class Delete_LeafNodes {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(2),null),
                new TreeNode(3,new TreeNode(2),new TreeNode(4)));
        System.out.println("Preorder Sequence of the Tree Before the Deletion of Target Node : ");
        Tree_Traversals.preOrder(root);

        System.out.println();

        System.out.println("Preorder Sequence of the Tree After Deletion of Target Node : ");
       Tree_Traversals.preOrder(removeLeafNodes(root,2));


    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root==null)return null;

        root.left=removeLeafNodes(root.left,target);
        root.right=removeLeafNodes(root.right,target);

        if(root.val==target && root.left==null && root.right==null){
            return null;
        }

        return root;
    }


}
