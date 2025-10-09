package LinkedList;

import java.util.List;

public class MergeTwoSorted {

    public static void main(String[] args) {


        ListNode head1=new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode head2=new ListNode(1,new ListNode(4,new ListNode(5)));

        printLL(mergeTwoLists(head1,head2));


    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy =new ListNode(-1);//For handling the head of the  merged List

        ListNode temp=dummy;//Pointer to build merged List


        while(list1!=null && list2!=null){

            if(list1.val<=list2.val){

                temp.next=list1;
                list1=list1.next;


            }else{
                temp.next=list2;
                list2=list2.next;

            }
            temp=temp.next;

        }

        //If any list still has remaining nodes ,append them to merged list

        if(list1!=null){
            temp.next=list1;


        }else{
            temp.next=list2;
        }

        return dummy.next; // The actual head of the merged list
    }


    public static void printLL(ListNode head){

        ListNode temp=head;
        while(temp!=null) {

            System.out.print(temp.val + " ");
            temp = temp.next;

        }
    }

}

