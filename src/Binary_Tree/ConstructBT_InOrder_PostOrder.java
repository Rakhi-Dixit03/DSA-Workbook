package Binary_Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBT_InOrder_PostOrder {

    public static void main(String[] args) {

        int[] inorder={3,9,20,15,7};
        int[] postorder={9,15,7,20,3};

        System.out.println("Root Node of Tree is : "+buildTree(inorder,postorder).val);

    }

    static int idx;
    static Map<Integer,Integer>map=new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        int n=inorder.length;
        idx=n-1;

        //Storing inorder elements for faster lookup
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }


        return solve(0,n-1,inorder,postorder);

    }

    private static TreeNode solve(int st,int end,int[] inorder, int[] postorder){

        if(st>end){
            return null;
        }


        int rootVal=postorder[idx];

        int i=map.get(rootVal);
        // int i=st;

        // for(;i<=end;i--){

        //    if(rootVal==postorder[i])break;


        // }

        TreeNode root=new TreeNode(rootVal);
        idx--;

        root.right=solve(i+1,end,inorder,postorder);
        root.left=solve(st,i-1,inorder,postorder);

        return root;
    }





}
