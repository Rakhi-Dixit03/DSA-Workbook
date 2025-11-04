package Binary_Tree;

import java.util.Map;
import java.util.HashMap;

public class ConstructBT_InOrder_PreOrder {

    public static void main(String[] args) {

        int[] inorder={3,9,20,15,7};
        int[] preorder={9,3,15,20,7};

        System.out.println("Root Node of Tree is : "+buildTree(inorder,preorder).val);


    }


    static int idx=0; //for traversing over preOrder array

    public  static TreeNode buildTree(int[] preorder, int[] inorder) {

        int n=preorder.length;

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){

            map.put(inorder[i],i);

        }

        return solve(0,n-1,preorder,inorder,map);


    }

    //TC-O(N)

    private static TreeNode solve(int start,int end,int[] preorder, int[] inorder,Map<Integer,Integer>map){

        if(start>end)return null;

        int rootVal=preorder[idx];

        // int i=start;

        // for(;i<=end;i++){

        //    if(inorder[i]==rootVal){
        //     break;
        //    }

        // }

        int i=map.get(rootVal);

        TreeNode root=new TreeNode(rootVal);
        idx++;

        root.left=solve(start,i-1,preorder,inorder,map);
        root.right=solve(i+1,end,preorder,inorder,map);


        return root;

    }


}
