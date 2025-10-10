package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CycleDetection {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode fourth=new ListNode(4);
        ListNode fifth=new ListNode(5);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=third;

        if(hasCycle2(head)) {
            System.out.println("Linked List contains Cycle!");
        }else{
            System.out.println("There is no cycle in this Linked List.");
        }

        if(hasCycle(head)) {
            System.out.println("Linked List contains Cycle!");
        }else{
            System.out.println("There is no cycle in this Linked List.");
        }

    }


    public static boolean hasCycle(ListNode head) {

        if(head==null || head.next==null )return false;

        Map<ListNode,Integer> map=new HashMap<>();

        ListNode temp=head;
        while(temp!=null){

            if(map.containsKey(temp)){
                return true;
            }

            map.put(temp,1);
            temp=temp.next;

        }

        return false;
    }

    public static boolean hasCycle2(ListNode head) {

        if(head==null || head.next==null )return false;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){//Condition of cycle
                return true;
            }

        }

        return false;

    }

    //Linked List Cycle-2

    public static ListNode detectCycle(ListNode head) {

        boolean isCycle=false;

        if(head==null || head.next==null )return null ;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){//Condition of cycle
                isCycle=true;
                break;
            }

        }

        if(!isCycle)return null;

        //Finding the starting node of cycle

        slow=head;

        while(slow!=fast){

            slow=slow.next;
            fast=fast.next;

        }

        return slow;
    }

}
