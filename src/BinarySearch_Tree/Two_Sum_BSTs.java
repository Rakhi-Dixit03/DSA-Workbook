package BinarySearch_Tree;

import Binary_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Two_Sum_BSTs {

    public static void main(String[] args) {

        TreeNode root1=new TreeNode(3,new TreeNode(2),new TreeNode(5));
        TreeNode root2=new TreeNode(4,new TreeNode(1),new TreeNode(6));

        Two_Sum_BSTs obj=new Two_Sum_BSTs();
        System.out.println("Two Sum BSTs Output : "+obj.twoSumBSTs(root1,root2,20));


    }

   public boolean twoSumBSTs(TreeNode root1,TreeNode root2,int target){

        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        inorder(root1,list1);
        inorder(root2,list2);


        int i=0,j=list2.size()-1;

        while(i<list1.size() && j>=0){

            int currSum=list1.get(i) + list2.get(j);

            if(currSum==target){
                return true;
            }

            if(currSum<target)i++;
            else j--;

        }

        return false;
   }


   private void inorder(TreeNode root, List<Integer>list){

        if(root==null)return;
        inorder(root.left,list);

        list.add(root.val);
        inorder(root.right,list);

   }
  //Can also be solved using Stack ,can also return pairs count as well
}
