package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_Deserialize_BT {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),
                new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));

        System.out.println("Before Serialisation : ");
        Tree_Traversals.preOrder(root);
        System.out.println();
        Serialize_Deserialize_BT ser=new Serialize_Deserialize_BT();

        Serialize_Deserialize_BT deser=new Serialize_Deserialize_BT();

        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println("After Serialisation : ");
        Tree_Traversals.preOrder(ans);



    }


    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializeHelper(root,sb);

        return sb.toString();


    }

    private void serializeHelper(TreeNode root,StringBuilder sb){
        //Simple PreOrder

        if(root==null){

            sb.append("null,");
            return ;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);


    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> q=new LinkedList<>(java.util.Arrays.asList(data.split(",")));

        return deserializeHelper(q);


    }

    private TreeNode deserializeHelper(Queue<String>q){

        String nodeValue=q.poll();

        if(nodeValue.equals("null")){
            return null;
        }

        TreeNode root=new TreeNode(Integer.parseInt(nodeValue));

        root.left= deserializeHelper(q);
        root.right=deserializeHelper(q);

        return root;

    }






}
