package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedList {

    public static void main(String[] args) {

        Node1 head=new Node1(1);
        Node1 sec=new Node1(2);
        Node1 third=new Node1(3);
        Node1 four=new Node1(4);
        Node1 fifth=new Node1(5);
        Node1 six=new Node1(6);

        head.next=sec;
        sec.next=third;
        third.next=four;
        four.next=fifth;
        fifth.next=six;

        third.random=four;
        fifth.random=sec;

        printLL(copyRandomList1(head));
        System.out.println();
        printLL(copyRandomList2(head));

    }


    static public Node1 copyRandomList1(Node1 head) {

        Node1 newHead=null;
        Node1 curr=head;
        Node1 prev=null;
        Map<Node1,Node1> map=new HashMap<>();

        //Building new Linked List

        while(curr!=null){

            if(newHead==null){
                Node1 newNode=new Node1(curr.val);
                newHead=newNode;
                map.put(curr,newNode);
                prev=newNode;

            }else{

                Node1 newNode=new Node1(curr.val);
                map.put(curr,newNode);
                prev.next=newNode;
                prev=newNode;

            }

            curr=curr.next;

        }

        //Modifying Random  pointers

        curr=head;
        Node1 newCurr=newHead;

        while(curr!=null){

            if(curr.random==null){
                newCurr.random=null;

            }else{

                newCurr.random=map.getOrDefault(curr.random,null);

            }

            //Move pointers
            curr=curr.next;
            newCurr=newCurr.next;

        }

        return newHead;

    }


    public static void printLL(Node1 head){

        Node1 temp=head;
        while(temp!=null) {

            System.out.print(temp.val + " ");
            temp = temp.next;

        }
    }

    //2nd Approach


   static public Node1 copyRandomList2(Node1 head) {

        if(head==null)return null;

        //Adding New Nodes in between original Linked List

        Node1 curr=head;

        while(curr!=null){

            // store curr.next value

            Node1 currNext=curr.next;
            //create new node
            Node1 newNode=new Node1(curr.val);
            curr.next=newNode;
            newNode.next=currNext;

            curr=currNext;

        }

        //Assigning Random Pointers

        curr=head;

        while(curr!=null && curr.next!=null){

            if(curr.random==null){

                curr.next.random=null;

            }else{

                curr.next.random=curr.random.next;

            }

            curr=curr.next==null?null:curr.next.next;


        }

        Node1 newHead=head.next;
        curr=head;
        Node1 newCurr=curr.next;

        //Separating the Linked Lists

        while(curr!=null && newCurr!=null){

            curr.next=curr.next==null?null:curr.next.next;
            newCurr.next=newCurr.next==null?null:newCurr.next.next;

            curr=curr.next;//Changed (New) curr.next
            newCurr=newCurr.next;

        }

        return newHead;
    }


}

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}