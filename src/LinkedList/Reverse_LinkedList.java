package LinkedList;

import java.util.LinkedList;

public class Reverse_LinkedList {

   static  Linkedlist ll=new Linkedlist();
    public static void main(String[] args) {


        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        System.out.println("Linked List before reversal : ");
        ll.printLL(ll.head);
        Node h=reverse(ll.head);
        System.out.println();
        //Print LinkedList
        System.out.println("Linked List after reversal : ");
        ll.printLL(h);

    }

    public static Node reverse(Node head) {

        Node curr = ll.tail = head;
        Node prev = null;
        Node next;


        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;
        return head;
    }

}


