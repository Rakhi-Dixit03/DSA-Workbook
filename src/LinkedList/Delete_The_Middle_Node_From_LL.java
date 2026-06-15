package LinkedList;

//TC-O(N)
//SC-O(1)

public class Delete_The_Middle_Node_From_LL {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null)
            return null;


        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode temp = head;
        while (temp.next != slow) {//As slow is pointing our middle node

            temp = temp.next;

        }

        //temp will be at prev node to middle node

        temp.next = slow.next;
        slow.next = null;

        return head;
    }


}
