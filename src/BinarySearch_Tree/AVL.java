package BinarySearch_Tree;

class Node {

    int val,height;
    Node left,right;

    public Node(int val){

        this.val=val;
        this.height=1;

    }


}

public class AVL {

    Node root;

    //Utility Methods [helper methods]

   private int height(Node n){
        if(n==null)return 0;

        return n.height;
    }

    private int getBalance(Node n){

        if(n==null)return 0;

        return height(n.left)-height(n.right);

    }

   //Rotations
    private Node rotateRight(Node y){

        Node x=y.left;
        Node t1=x.right;

        x.right=y;
        y.left=t1;

        y.height=1+Math.max(height(y.left),height(y.right));
        x.height=1+Math.max(height(x.left),height(x.right));

        return x;//new root
  }

 private  Node rotateLeft(Node x){

        Node y=x.right;
        Node t1=y.left;

        y.left=x;
        x.right=t1;


        y.height=1+Math.max(height(y.left),height(y.right));
        x.height=1+Math.max(height(x.left),height(x.right));

        return y;//new root
  }

//Insertion method

    Node insert(Node node,int val){

        //Normal BST insertion
        if(node==null)return new Node(val);


        if(val<node.val){

            node.left=insert(node.left,val);

        }else if(val>node.val){

            node.right=insert(node.right,val);

        }else{
            //node becomes equal to val
            //Duplicates are not allowed
            return node;

        }

        //while going back upward for every node
        //update height

        node.height=1+Math.max(height(node.left),height(node.right));


        //get the balance factor

        int balance=getBalance(node);


        //check 4 cases of rotations(if required)

        //LL

        if(balance>1 && val <node.left.val){
            //Rotate Right
            return rotateRight(node);

        }

        //RR
        if(balance<-1 && val>node.right.val){
            //Rotate Left
            return rotateLeft(node);

        }

        //LR

        if(balance>1 && val>node.left.val){

            node.left=rotateLeft(node.left);
           return rotateRight(node);
        }

       //RL

        if(balance<-1 && val<node.right.val){

            node.right=rotateRight(node.right);
            return rotateLeft(node);
        }

       return node;//unchanged

    }


    //Deletion
    Node delete(Node root,int key){

       //Normal BST deletion

        if(root==null)return  null;


       if(key< root.val){
           root.left=delete(root.left,key);

       }else if(key>root.val){

           root.right=delete(root.right,key);

       }else{
           //We have got our node to be deleted

           //case: one child and no child case

           if(root.left==null){

               Node temp=root.right;
               root.right=null;

               return temp;
           }else if(root.right==null){

               Node temp=root.left;
               root.left=null;
               return temp;
           }

           //3rd case 2 children

           Node temp=inOrderSucc(root.right);

           root.val=temp.val;

           root.right=delete(root.right,temp.val);//deleting inorder successor


       }


       //update height

        root.height=1+Math.max(height(root.left),height(root.right));

       //get balance facter

        int balance = getBalance(root);


        //fixing imbalance 4 cases

       //LL case

        if(balance>1 && getBalance(root.left)>=0){

            return rotateRight(root);


        }

       //LR case
        if(balance>1 &&  getBalance(root.left)<0){

            root.left=rotateLeft(root.left);
            return rotateRight(root);

        }

       //RR case

        if(balance<-1 && getBalance(root.right)<=0){

            return rotateLeft(root);


        }

        //RL case

        if(balance<-1 && getBalance(root.right)>0){

            root.right=rotateRight(root.right);
            return rotateLeft(root);
        }


        return root;

    }


    private Node inOrderSucc(Node root){

        if(root==null)return  null;
        Node curr=root;

        while(curr.left!=null){

            curr=curr.left;

        }

        return curr;
    }

void inorder(Node root){

       if(root==null)return;

       inorder(root.left);
        System.out.print(root.val+" ");

       inorder(root.right);

    }



}
