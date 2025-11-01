package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_Traversal {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));

        System.out.println(levelOrder(root));
        System.out.println(levelOrder1(root));

    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;//empty Tree

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);//Storing val and level at which that node is present

        while (!q.isEmpty()) {

            int size = q.size(); // number of nodes at current level

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                list.add(curr.val);

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }

            ans.add(list);
        }

        return ans;

    }

    //Can Also write recursive method

    public static List<List<Integer>> levelOrder1(TreeNode root) {


        List<List<Integer>>res=new ArrayList<>();

        if(root==null)return res;

        helper(root,res,0);

        return res;

    }

    public static void helper(TreeNode root,List<List<Integer>> res,int level){

        //Base case

        if(root==null)return;

     //Logic
        if(level==res.size()){//means we are done with 1 level need to do to next,So Initialise arrayList

            res.add(new ArrayList<>());

        }

        res.get(level).add(root.val);

        //Recursive calls to left and right subtrees

        helper(root.left,res,level+1);
        helper(root.right,res,level+1);


    }

}
