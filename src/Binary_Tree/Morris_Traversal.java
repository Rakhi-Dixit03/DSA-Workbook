package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Morris_Traversal {

    static List<Integer> ans=new ArrayList<>();

    public static void main(String[] args) {


        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));
        TreeNode root1=new TreeNode(1,new TreeNode(2,new TreeNode(4),
                new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));


        inOrder(root);
        System.out.println(ans.toString());
        inOrder1(root1);


    }

    //find inorder predecessor
    private static void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null) {

            //L V R
            if (curr.left == null) {

                ans.add(curr.val);//visited node

                curr = curr.right;

            } else {

                TreeNode leftNode = curr.left;//Left Child's rightMost node

                while (leftNode.right != null) {

                    leftNode = leftNode.right;

                }

                leftNode.right = curr;

                //Break the connection of curr node with leftNode

                TreeNode temp = curr.left;
                curr.left = null;

                curr = temp;

            }

        }

    }

     public static void inOrder1(TreeNode root){

        java.util.Stack<TreeNode>st=new Stack<>();

       TreeNode curr=root;

        while(curr!=null || !st.isEmpty()){

            while(curr!=null){

                st.push(curr);
                curr=curr.left;

            }

            curr=st.pop();
            System.out.print(curr.val+" ");

            curr=curr.right;


        }

     }


}
