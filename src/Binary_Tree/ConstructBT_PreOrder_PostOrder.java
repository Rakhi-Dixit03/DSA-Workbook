package Binary_Tree;

import java.util.Map;
import java.util.HashMap;

public class ConstructBT_PreOrder_PostOrder {

    public static void main(String[] args) {

        int[] preorder={1,2,4,5,3,6,7};
        int[] postorder={4,5,2,6,7,3,1};

        System.out.println("Root Node of the tree : "+constructFromPrePost(preorder,postorder).val);


    }


   static Map<Integer,Integer>map=new HashMap<>();

    public  static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        int n=preorder.length;

        //Storing inorder elements for faster lookup
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }

        return solve(0,0,n-1,preorder,postorder);

    }

    private static TreeNode solve(int preSt,int postSt,int preEnd,int[] preorder, int[] postorder){

        if(preSt>preEnd)return null;//Invalid condition

        TreeNode root=new TreeNode(preorder[preSt]);

        if(preSt==preEnd)return root;//leaf node condition

        if(preSt+1>=preorder.length)return root;//no more nodes


        int  nextNode= preorder[preSt+1];
       //Can do this as well but time taking
        // int j=postSt;

        // while(postorder[j]!=nextNode){

        //    j++;
        // }

        int j=map.get(nextNode);


        int num=j-postSt+1;//number of nodes in a subtree

        root.left=solve(preSt+1,postSt,preSt+num,preorder,postorder);//Left Subtree
        root.right=solve(preSt+num+1,j+1,preEnd,preorder,postorder);//Right Subtree

        return root;

    }




}
