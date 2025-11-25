package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Duplicate_SubTrees {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),null),
                new TreeNode(3,new TreeNode(2,new TreeNode(4),null),new TreeNode(4)));

         Find_Duplicate_SubTrees obj=new Find_Duplicate_SubTrees();

         List<TreeNode>list=obj.findDuplicateSubtrees(root);
         System.out.println("All Duplicate Subtrees' preorder Sequences : ");
         for(TreeNode node:list){
             System.out.print("[");
             Tree_Traversals.preOrder(node);
             System.out.print("]");
         }


    }

    List<TreeNode> result=new ArrayList<>();
    Map<String,Integer> map=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        serialize(root);

        return result;

    }

    String serialize(TreeNode root){

        if(root==null)return "#";

        String leftTree=serialize(root.left);
        String rightTree=serialize(root.right);

        String signature= root.val+","+leftTree+","+rightTree;

        map.put(signature,map.getOrDefault(signature,0)+1);

        if(map.get(signature)==2)result.add(root);

        return signature;

    }

}
