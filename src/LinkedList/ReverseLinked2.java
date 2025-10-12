package LinkedList;

public class ReverseLinked2 {

    public static void main(String[] args) {

        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));

        MergeTwoSorted.printLL(reverseBetween(head,2,4));

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(head.next==null)return head;

        ListNode a=null,b=null,c=null,d=null;
        int count=1;
        ListNode curr=head;
        //Finding 4 nodes

        while(curr!=null){

            if(count==left-1)a=curr;
            if(count==left)b=curr;
            if(count==right)c=curr;
            if(count==right+1)d=curr;


            curr=curr.next;
            count++;

        }


        //Detaching sublist to be reversed

        if(a!=null)a.next=null;
        if(c!=null) c.next=null;

        //Reversing sublist
        reverseList(b);

        //ReConnecting sublist
        if(a!=null) a.next=c;
        if(b!=null)b.next=d;
        if(a==null)return c;
        return head;

    }


    public static void reverseList(ListNode head){
        //Doing modifications in the sublist
        ListNode next,prev=null;

        while(head!=null){

            next=head.next;
            head.next=prev;
            prev=head;
            head=next;

        }

    }

}
