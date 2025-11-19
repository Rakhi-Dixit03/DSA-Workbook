package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

public class Serialize_Deserialize_BST {

    public static void main(String[] args) {

        TreeNode  root=new TreeNode(6,new TreeNode(4,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,new TreeNode(8),new TreeNode(16)));

        System.out.println("Before Serialisation : ");
        Tree_Traversals.inOrder(root);
        System.out.println();
        Serialize_Deserialize_BT ser=new Serialize_Deserialize_BT();

        Serialize_Deserialize_BT deser=new Serialize_Deserialize_BT();

        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println("After Serialisation : ");
        Tree_Traversals.inOrder(ans);


    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb=new StringBuilder();
        serializeHelper(root,sb);

        return sb.toString();


    }

    private void serializeHelper(TreeNode root,StringBuilder sb){

        if(root==null){
            return;
        }


        sb.append(root.val).append(",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);

    }

    int index=0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty())return null;
        String[] values=data.split(",");

        return helper(values,Integer.MIN_VALUE,Integer.MAX_VALUE);



    }

    TreeNode helper(String[] values,int min,int max){

        if(index==values.length)return null;

        int val=Integer.parseInt(values[index]);

        if(val<min || val>max){//out of valid range

            return null;

        }

        index++;

        TreeNode root=new TreeNode(val);
        root.left=helper(values,min,val);
        root.right=helper(values,val,max);

        return root;

    }



}
