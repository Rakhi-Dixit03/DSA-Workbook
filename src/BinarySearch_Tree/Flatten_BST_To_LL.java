package BinarySearch_Tree;

import Binary_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Flatten_BST_To_LL {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, new TreeNode(8), new TreeNode(16)));

        Flatten_BST_To_LL obj = new Flatten_BST_To_LL();

//        System.out.println("Flattened BST Using 1st Method : ");
//       obj.printLL(obj.FlattenBST1(root));

        System.out.println("Flattened BST  Using 2nd Method : ");

        obj.flattenBST2(root);
        obj.printLL(obj.head);


    }

    //Using a List of Nodes SC-O(N) TC-O(2N)

    List<TreeNode> list = new ArrayList<>();

    private TreeNode FlattenBST1(TreeNode root) {

        inOrder(root);
        TreeNode head = list.get(0);
        TreeNode temp = head;
        for (int i = 1; i < list.size(); i++) {

            temp.right = list.get(i);
            temp.left = null;
            temp = temp.right;

        }

        return head;
    }

    private void inOrder(TreeNode root) {

        if (root == null) return;

        inOrder(root.left);
        list.add(root);

        inOrder(root.right);

    }

    private void printLL(TreeNode head) {

        if (head == null) System.out.println("Linked-List is Empty!");
        while (head.right != null) {

            System.out.print(head.val + " -> ");
            head = head.right;


        }
        System.out.println(head.val + " -> NULL");


    }


    //Without List, Modifying in-Place

    TreeNode prev = null;
    TreeNode head = null;

    private void flattenBST2(TreeNode root) {

        if (root == null) return;

        //Performing inorder with slight modification

        //Going to the left Subtree
        flattenBST2(root.left);

        //Processing Node
        if (prev != null) {

            prev.right = root;
            root.left = null;

        }

        if (head == null) {//Just to print the LL,storing its head
            head = root;
        }


        prev = root;//Updating previous


        //Going to the right Subtree
        flattenBST2(root.right);


    }


}
