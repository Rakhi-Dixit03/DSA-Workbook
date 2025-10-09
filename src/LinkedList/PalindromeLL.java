package LinkedList;

import java.awt.*;
import java.util.Collections;
import java.util.Stack;

public class PalindromeLL {

    public static void main(String[] args) {

        ListNode head=new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1,new ListNode(3)))));
        System.out.println(isPalindrome(head));
        System.out.println(checkPalindrome(head));


    }

    //Using no extra space
    public static boolean checkPalindrome(ListNode head){

        if(head==null || head.next==null)return true;


        //Finding middle of the linked list

        ListNode slow =head;
        ListNode fast =head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }

        //Reversing 2nd Half

        ListNode reversedHead=reverse(slow.next);
        ListNode head2=reversedHead;

        //Comparing 2 halves
        ListNode temp=head;

        while(reversedHead!=null){

            if(temp.val!=reversedHead.val)return false;
            temp=temp.next;
            reversedHead=reversedHead.next;

        }

        //Bringing the LL in same state

        slow.next=reverse(head2);
        MergeTwoSorted.printLL(head);
        System.out.println();

        return true;

    }
  //Using auxiliary Space
    public static boolean isPalindrome(ListNode head) {

        Stack<Integer> st=new Stack<>();
        ListNode temp=head;

        while(temp!=null){

            st.push(temp.val);
            temp=temp.next;

        }

        temp=head;
        while(temp!=null){

            if(st.pop()!=temp.val){
                return false;
            }

            temp=temp.next;

        }

        return true;

    }

    public static ListNode reverse(ListNode head){
        //Reversing LL

        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;

        while(curr!=null){

            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;

    }


}
