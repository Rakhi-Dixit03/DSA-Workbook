package Binary_Tree;

import java.util.LinkedList;

public class Invert_Tree {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));

        TreeNode root2=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));

        Tree_Traversals.preOrder(invertTree(root));
        System.out.println();
        Tree_Traversals.preOrder(invertTree2(root2));

    }


    public static TreeNode invertTree(TreeNode root) {

        helper(root);
        return root;

    }

    private static void helper(TreeNode root){

        if(root==null)return;

        //swap
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;


        //invert children recursively


        invertTree(root.left);
        invertTree(root.right);



    }

    //Using Queue

    public static TreeNode invertTree2(TreeNode root){

        java.util.Queue<TreeNode>q=new LinkedList<>();

        q.add(root);


        while(!q.isEmpty()){

            TreeNode curr=q.poll();

            //Swap children
            TreeNode temp=curr.left;
            curr.left=curr.right;
            curr.right=temp;


            if(curr.left!=null){

                q.add(curr.left);
            }

            if(curr.right!=null){

                q.add(curr.right);
            }


        }

        return root;
    }

}
