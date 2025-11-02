package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));

        System.out.println("Sum is maximum at level : "+maxLevelSum(root));

    }

    public  static int maxLevelSum(TreeNode root) {

        if(root==null)return 0;//if tree is empty Max Sum = 0

        Queue<TreeNode> q=new LinkedList<>();

        int maxLevel=1;
        int currLevel=1;

        int maxSum=Integer.MIN_VALUE;//Here we have to initialise it with -infinity not with 0 because -ve integers are also allowed

        q.add(root);

        while(!q.isEmpty()){

            int currSum=0;

            int levelSize=q.size();//Nodes at curr level

            for(int i=0;i<levelSize;i++){

                TreeNode curr=q.poll();
                currSum+=curr.val;


                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);

            }

            if(currSum>maxSum){

                maxSum=currSum;
                maxLevel=currLevel;


            }

            currLevel++;

        }

        return maxLevel;

    }





}
