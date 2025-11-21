package BinarySearch_Tree;

import Binary_Tree.TreeNode;
import Binary_Tree.Tree_Traversals;

import java.util.*;

public class MergeBSTs_ToSingle_BST {

    public static void main(String[] args) {

      TreeNode t1=new TreeNode(2,new TreeNode(1),null);
      TreeNode t2=new TreeNode(3,new TreeNode(2),new TreeNode(5));
      TreeNode t3=new TreeNode(5,new TreeNode(4),null);

      MergeBSTs_ToSingle_BST obj=new MergeBSTs_ToSingle_BST();

      List<TreeNode>list=new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        System.out.println("Inorder Sequence of Tree After Merging : ");
        Tree_Traversals.inOrder(obj.canMerge(list));


    }


    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> leaves = new HashSet<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        //Building map and set

        for (TreeNode node : trees) {

            map.put(node.val, node);

            if (node.left != null)
                leaves.add(node.left.val);
            if (node.right != null)
                leaves.add(node.right.val);

        }

        //Finding root node
        TreeNode root = null;

        for (TreeNode node : trees) {

            if (!leaves.contains(node.val)) {
                root = node;
                break;
            }

        }

        if (root == null) {//We haven't found a root node
            return null;
        }

        map.remove(root.val);//so that we can't consider it as a subtree to merge

        if (!mergeAndValidateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return null;

        if (!map.isEmpty())
            return null;//it means some trees are left to be merged


        return root;//This will be the root of our final BST

    }

    private boolean mergeAndValidateBST(TreeNode node, int min, int max) {

        if (node == null)
            return true;

        //Checking  Valid BST condition

        if (node.val <= min || node.val >= max)
            return false;

        if (node.left != null && map.containsKey(node.left.val)) {//merge it to the left of the tree
            node.left = map.get(node.left.val);

            map.remove(node.left.val);

        }

        if (node.right != null && map.containsKey(node.right.val)) {//merge it to the right of the tree
            node.right = map.get(node.right.val);

            map.remove(node.right.val);

        }

        return mergeAndValidateBST(node.left, min, node.val) && mergeAndValidateBST(node.right, node.val, max);

    }

}
