package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BT_Operations {

    public static void main(String[] args) {


        TreeNode  root=new TreeNode(10,new TreeNode(11,new TreeNode(7),null),
                new TreeNode(9,new TreeNode(15),new TreeNode(8)));


        BT_Operations obj=new BT_Operations();

        Tree_Traversals.inOrder(obj.insertBT(root,12));
        System.out.println();
        System.out.println("Search result : "+obj.searchBT(root,16));


        System.out.println("After Deletion : ");
        Tree_Traversals.inOrder( obj.deleteBT(root,11));

    }


    //Insert in a BT

    public TreeNode insertBT(TreeNode root,int val){

        if(root==null){

            root= new TreeNode(val);
            return root;
        }

        Queue<TreeNode>q=new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            TreeNode curr=q.poll();

            if(curr.left!=null){

                q.add(curr.left);

            }else{
                curr.left=new TreeNode(val);
                return root;

            }

            if(curr.right!=null) {
                q.add(curr.right);

            }else{
                curr.right=new TreeNode(val);
                return root;

            }

        }

        return root;
    }

    //Search in a BT

    public boolean searchBT(TreeNode root,int key){

        if(root==null)return false;

        if(root.val==key)return true;


        boolean ans1=searchBT(root.left,key);

        if(ans1)return true;


        return searchBT(root.right,key);

    }

    //Delete in BT

    TreeNode deleteBT(TreeNode root, int key) {

        if (root == null) return null;

        //if tree has single node

        if (root.left == null && root.right == null) {

            if (root.val == key) {
                root = null;

            }

            return root;

        }


        //Traverse over tree and find the node to be deleted


        Queue<TreeNode> q = new LinkedList<>();

        TreeNode curr = null;
        TreeNode nodeTobeDeleted = null;
        TreeNode parDeepest = null;


        q.add(root);

        while (!q.isEmpty()) {

            curr = q.poll();

            if (curr.val == key) {
                nodeTobeDeleted = curr;
            }

            if (curr.left != null) {

                parDeepest = curr;
                q.add(curr.left);
            }

            if (curr.right != null) {

                parDeepest = curr;
                q.add(curr.right);

            }


        }

        if (nodeTobeDeleted != null) {

            nodeTobeDeleted.val = curr.val;

            if (parDeepest.right == curr) {

                parDeepest.right = null;

            } else {

                parDeepest.left = null;
            }

        }

        return root;
    }



}
