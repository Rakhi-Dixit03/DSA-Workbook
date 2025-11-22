package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBSTs {

    public static void main(String[] args) {

        TreeNode root1=new TreeNode(2,new TreeNode(1),new TreeNode(4));
        TreeNode root2=new TreeNode(9,new TreeNode(3),new TreeNode(12));

        MergeTwoBSTs obj=new MergeTwoBSTs();

        Tree_Traversals.inOrder(obj.mergeBSTs(root1,root2));

    }

    public TreeNode mergeBSTs(TreeNode root1,TreeNode root2){

        List<Integer> list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        List<Integer>list3=new ArrayList<>();

        //Using same methods [inorder] and [buildTree] from BST_To_BalancedBST class

        BST_To_BalancedBST obj=new BST_To_BalancedBST();

        obj.inorder(root1,list1);
        obj.inorder(root2,list2);


        //Merging these inorder Sequences into single sorted list

        int i=0;
        int j=0;
        while(i< list1.size() && j<list2.size()){

            if(list1.get(i)<list2.get(j)){
                list3.add(list1.get(i));
                i++;
            }else{

                list3.add(list2.get(j));
                j++;
            }

        }

        while(i<list1.size()){
            list3.add(list1.get(i));
            i++;

        }

        while(j<list2.size()){

            list3.add(list2.get(j));
            j++;
        }

        //using build Tree Method for building BST from final Sorted List [list3]

        return obj.buildTree(list3,0,list3.size()-1);


    }


}
