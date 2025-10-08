package LinkedList;

import java.util.LinkedList;

public class Linkedlist{

    public  Node head;
    public  Node tail;

     public void addFirst(int data){
         Node newNode=new Node(data);

        if(head==null){
            head=tail=newNode;
            return;
        }

         newNode.next=head;
         head=newNode;

     }


     public void addLast(int data){

         Node newNode=new Node(data);
         Node temp=head;
         Node prev=null;

         if(head==null){
             head=tail=newNode;
         }
         while(temp!=null){
             prev=temp;
             temp=temp.next;

         }

         prev.next=newNode;

     }

     public void printLL(Node head){

         Node temp=head;
         while(temp!=null){

             System.out.print(temp.data+" ");
             temp=temp.next;

         }

     }

}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}



