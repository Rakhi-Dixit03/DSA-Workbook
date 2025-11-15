package BinarySearch_Tree;

import Binary_Tree.Tree_Traversals;

public class Populate_Next_Right_Pointers {

    static class Node{

        int val;
        Node left;
        Node right;
        Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }


    }

    public static void main(String[] args) {

        Node root=new Node(1,new Node(2,new Node(4),new Node(5),null),
                new Node(3,new Node(6),new Node(7),null),null);

        printTree(connect(root));


    }

    public static Node connect(Node root) {

        if(root==null)return root;

        Node leftMost=root;//leftMost node of each level for traversing each level

        while(leftMost.left!=null){

            Node curr=leftMost;//Node for going on each node in a level

            while(curr!=null){
                curr.left.next=curr.right ;

                if(curr.next!=null){

                    curr.right.next=curr.next.left;
                }

                curr=curr.next;//going to each node of this level
            }


            leftMost=leftMost.left;

        }

        return root;
    }

   static void printTree(Node root){

        if(root==null)return;

       System.out.println("Node's Data : "+root.val+" next Value -> "+(root.next!=null?root.next.val:null));

        printTree(root.left);
        printTree(root.right);

   }

}

