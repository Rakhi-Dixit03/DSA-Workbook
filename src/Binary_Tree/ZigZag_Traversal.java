package Binary_Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZag_Traversal {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7,null,new TreeNode(8))));

        ZigZag_Traversal obj=new ZigZag_Traversal();

        System.out.println(obj.zigzagLevelOrder(root));

    }

    //Will use BFS Approach [Level Order Traversal] +Deque


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>>ans=new ArrayList<>();

        if(root==null)return ans;

        boolean reverse=false;

        Deque<TreeNode> dq=new LinkedList<>();

        dq.add(root);

        while(!dq.isEmpty()){

            int size=dq.size();

            List<Integer>level=new ArrayList<>();

            if(!reverse){//going from left to right

                for(int i=0;i<size;i++){
                    TreeNode node=dq.pollFirst();
                    level.add(node.val);

                    if(node.left!=null)dq.addLast(node.left);
                    if(node.right!=null)dq.addLast(node.right);
                }

            } else{ //going from right to left

                for(int i=0;i<size;i++){

                    TreeNode node=dq.pollLast();
                    level.add(node.val);

                    if(node.right!=null)dq.addFirst(node.right);
                    if(node.left!=null)dq.addFirst(node.left);
                }
            }

            reverse=!reverse;
            ans.add(level);

        }
        return ans;
    }

}
