package Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Left_and_Right_Views {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));

        System.out.println(rightSideView(root));

        System.out.println(leftSideView(root));


    }


    public static  List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans=new ArrayList<>();

        helper(root,0,ans);

        return ans;

    }

    private static void helper(TreeNode root,int level,List<Integer>ans){

        if(root==null)return;

        //Reversed Preorder Traversal

        //Root,Right,Left

        if(ans.size()==level){
            ans.add(root.val);
        }

        //Go to right subtree

        helper(root.right,level+1,ans);

        //Go to left subtree

        helper(root.left,level+1,ans);


    }

  //Left View Of a Tree



    public static  List<Integer> leftSideView(TreeNode root) {

        List<Integer> ans=new ArrayList<>();

        helper2(root,0,ans);

        return ans;

    }

    private static void helper2(TreeNode root,int level,List<Integer>ans){

        if(root==null)return;

        // Simple Preorder Traversal

        //Root,Right,Left

        if(ans.size()==level){
            ans.add(root.val);
        }

        //Go to left subtree

        helper2(root.left,level+1,ans);

        //Go to right subtree

        helper2(root.right,level+1,ans);


    }


}

