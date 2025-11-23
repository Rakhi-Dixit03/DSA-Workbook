package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

public class BST_Operations {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(6,new TreeNode(4,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,new TreeNode(8),new TreeNode(16)));

        BST_Operations obj=new BST_Operations();

        Tree_Traversals.inOrder( obj.insertBST(root,7));
        System.out.println();
        System.out.println("Search result : "+obj.searchBST(root,23));

        Tree_Traversals.inOrder( obj.deleteBST(root,14));


    }

//Insert in BST
    public TreeNode insertBST(TreeNode root,int val){

        if(root==null)return new TreeNode(val);

        if(root.val>val){

            root.left=insertBST(root.left,val);

        }else if(root.val<val){

            root.right=insertBST(root.right,val);

        }

        return root;

    }

//Search in BST
    public TreeNode searchBST(TreeNode root,int key){

        if(root==null)return null;

        if(root.val==key)return root;
        else if(root.val>key){

            return searchBST(root.left,key);

        }

        return searchBST(root.right,key);

    }

    //Delete in BST

    public TreeNode deleteBST(TreeNode root,int key){

        if(root==null)return null;
        //first we need to search for the node to be deleted

        if(root.val<key){

            root.right=deleteBST(root.right,key);

        }else if(root.val>key){

            root.left=deleteBST(root.left,key);

        }else{
            //Node to be deleted
          // This will handle both one child and no child cases
            if(root.left==null){
                TreeNode temp=root.right;
                root.right=null;
                return temp;

            }else if(root.right==null){

                TreeNode temp=root.left;
                root.left=null;

                return temp;

            }

            //Case 3 : Two children case

            TreeNode temp=inOrderSucc(root.right);
            root.val=temp.val;

            root.right=deleteBST(root.right,temp.val);

        }

        return root;

    }


    TreeNode inOrderSucc(TreeNode root){
        if(root==null)return  null;
        TreeNode curr=root;

        while(curr.left!=null){

            curr=curr.left;

        }

        return curr;
    }


}
