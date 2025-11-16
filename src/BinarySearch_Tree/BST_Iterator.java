package BinarySearch_Tree;

import Binary_Tree.TreeNode;

import java.util.Stack;

public class BST_Iterator {

    public static void main(String[] args) {

        TreeNode  root=new TreeNode(6,new TreeNode(4,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,new TreeNode(8),new TreeNode(16)));

        BSTIterator itr=new BSTIterator(root);

        System.out.println(itr.next());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.next());



    }

    static class BSTIterator {
        Stack<TreeNode> st = new Stack<>();

        public BSTIterator(TreeNode root) {

            storeLeftNodes(root);

        }

        public int next() {

            TreeNode ans = st.pop();

            if (ans.right != null) {

                storeLeftNodes(ans.right);
            }

            return ans.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        private void storeLeftNodes(TreeNode root) {

            while (root != null) {

                st.push(root);
                root = root.left;

            }


        }


    }
   //Can also be solved using a List to Store Inorder sequence[inorder method] and then performing operations accordingly

}
