package Binary_Tree;

import java.util.LinkedList;

public class Symmetric_Tree {

    public static void main(String[] args) {

        TreeNode  root=new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                new TreeNode(2,new TreeNode(4),new TreeNode(3)));


        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));

    }


    public static boolean isSymmetric(TreeNode root) {

        if(root==null)return true;

        return helper(root.left,root.right);
    }

    private static boolean helper(TreeNode l,TreeNode r){

        //Edge Cases
        //when both are null
        if(l==null && r==null)return true;
        //When one of them is null
        if(l==null || r ==null)return false;

        //When none of them is null

        return (l.val==r.val) && helper(l.left,r.right) && helper(l.right,r.left);

    }

    //Using Queue

    public static boolean isSymmetric2(TreeNode root){

        if(root==null)return true;//Empty tree is always symmetric

        java.util.Queue<TreeNode>q=new LinkedList<>();


        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){

            TreeNode l=q.poll();
            TreeNode r=q.poll();

            if(l==null && r== null)continue;

            if(l==null || r==null)return false;

            if(l.val!=r.val)return false;

            //Enqueue children in opposite order

            q.add(l.right);
            q.add(r.left);
            q.add(l.left);
            q.add(r.right);


        }
        return true;

    }

}
