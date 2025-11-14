package BinarySearch_Tree;

import Binary_Tree.TreeNode;

public class LCA_in_BST {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(4,new TreeNode(2),new TreeNode(1));

        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(5);
        root.right.left=new TreeNode(7);

        TreeNode node1=root.right.right;
        TreeNode node2=root.right.left;

        System.out.println("LCA is : "+lowestCommonAncestor(root,node1,node2).val);  //5 and 7
        System.out.println("LCA is : "+lowestCommonAncestor1(root,node1,node2).val);


    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)return null;


        if(p.val<root.val  && q.val<root.val){

            root=lowestCommonAncestor(root.left,p,q);

        }

        if(p.val>root.val  && q.val>root.val){

            root=lowestCommonAncestor(root.right,p,q);
        }

        //This is the case of divergence means one node is in left subtree and other is in right subtree

        return root;//Node root will be the LCA due to BST ordering

    }


    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {


        while(root!=null){


            if(p.val<root.val  && q.val<root.val){

                root=root.left;

            }else if(p.val>root.val  && q.val>root.val){

                root=root.right;
            }else{

                return root;
            }

        }

        return null;

    }


}
