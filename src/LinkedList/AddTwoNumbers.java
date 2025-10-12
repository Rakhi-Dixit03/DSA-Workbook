package LinkedList;

public class AddTwoNumbers {


    public static void main(String[] args) {

        ListNode head1=new ListNode(2,new ListNode(4,new ListNode(9)));
        ListNode head2=new ListNode(5,new ListNode(6,new ListNode(4,new ListNode(9))));

        ListNode head3=addTwoNumbers(head1,head2);
        MergeTwoSorted.printLL(head3);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newHead=new ListNode(0);//dummy node to handle new list
        ListNode temp=newHead;//This  is for traversing over the newList
        int carry=0;


        while(l1!=null || l2!=null || carry!=0){

            int val1= l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;


            int sum=val1+val2+carry;

            ListNode newNode=new ListNode(sum%10);

            carry=sum/10;
            temp.next=newNode;
            temp=temp.next;

            //Move both List pointers

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;

        }

        newHead= newHead.next;
        return newHead;

    }

}
