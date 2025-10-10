package LinkedList;

public class RemoveCycle {

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

       removeCycle(head);


    }

   public static void removeCycle(ListNode head){

           boolean isCycle=false;

           if(head==null || head.next==null ){
               System.out.println("Linked List has no cycle.");
               return ;
           }

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

           if(!isCycle) {
               System.out.println("Linked List has no cycle.");
               return ;
           }

           //Finding the starting node of cycle

           slow=head;

           while(slow!=fast){

               slow=slow.next;
               fast=fast.next;

           }

           ListNode curr= slow;

           //Finding the previous Node to the starting node of cycle

            while(curr.next!=slow){

                curr=curr.next;

            }

            //removing the cycle

             curr.next=null;

            MergeTwoSorted.printLL(head);
            System.out.println();
            System.out.println("Cycle Removed!");

       }
   }

