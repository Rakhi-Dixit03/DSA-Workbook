package BinarySearch_Tree;

import Binary_Tree.Tree_Traversals;

public class AVLDriver {

    public static void main(String[] args) {

        AVL avlTree=new AVL();

        avlTree.root=avlTree.insert(avlTree.root,5);
        avlTree.root=avlTree.insert(avlTree.root,10);
        avlTree.root=avlTree.insert(avlTree.root,20);
        avlTree.root=avlTree.insert(avlTree.root,30);

        System.out.println("Inorder Traversal after insertion : ");
        avlTree.inorder(avlTree.root);

       avlTree.root=avlTree.delete(avlTree.root,20);
        System.out.println();

        System.out.println("Inorder Traversal after deletion : ");
        avlTree.inorder(avlTree.root);

    }


}
