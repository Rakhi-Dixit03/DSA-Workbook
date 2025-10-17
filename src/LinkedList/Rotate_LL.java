package LinkedList;

public class Rotate_LL {


    public static void main(String[] args) {

        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode newHead=rotateRight(head,2);

        MergeTwoSorted.printLL(newHead);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if(head==null || k==0)return head;

        //Calculating the size of the list
        int n=1;//size
        ListNode temp=head;

        while(temp.next!=null){
            temp=temp.next;
            n++;
        }

        //Updating k
        k=k%n;

        if(k==0)return head;

        //Forming a cycle

        temp.next=head;

        //find the new tail, size-k%size steps from the head

        ListNode tail=head;

        for(int i=1;i<n-k;i++){
            tail=tail.next;

        }

        //Break cycle

        head=tail.next;
        tail.next=null;

        return head;

    }

}
