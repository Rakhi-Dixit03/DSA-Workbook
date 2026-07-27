package LinkedList;


public class Remove_Duplicates_From_Sorted_LL {
   //Part -1  Ques No.-83
    public static ListNode deleteDuplicates1(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode curr = head;

        while (curr != null) {
            //skip duplicates
            while (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }

            curr = curr.next;

        }

        return head;

    }

    //Part-2 Ques No.- 82

    public static ListNode deleteDuplicates2(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0, head);

        ListNode prev = dummy;

        ListNode curr = head;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {
                //Duplicate case

                while (curr.next != null && curr.val == curr.next.val) {

                    curr = curr.next;

                }

                prev.next = curr.next;

            } else {

                prev = curr;

            }

            curr = curr.next;
        }

        return dummy.next;
    }

    public static void printLL(ListNode head){
        ListNode curr=head;
        while(curr.next!=null){

            System.out.print(curr.val + "->");
            curr=curr.next;

        }
        System.out.print(curr.val + "-> null");

    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(5)))));

        System.out.println("Linked List After Duplicate Removal : ");
        printLL(deleteDuplicates1(head));
        System.out.println();
        System.out.println("Linked List After Duplicate Removal : ");
        printLL(deleteDuplicates2(head));




    }

}
