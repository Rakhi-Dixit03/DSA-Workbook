package LinkedList;
//TC-O(N)
//Find the middle of the list, reverse the second half, and use two pointers to calculate twin sums.
public class Max_Twin_Sum_LL {

    public int getSize(ListNode head) {

        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            size++;

            temp = temp.next;

        }
        return size;
    }

    public ListNode reverseLL(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    public int pairSum(ListNode head) {

        ListNode temp = head;
        int i = 0;

        int n = getSize(head);

        //Finding Mid-Node
        while (i < n / 2) {

            temp = temp.next;
            i++;

        }

        ListNode revLLHead = reverseLL(temp);//temp = midNode
        temp = head;
        i = 0;

        int maxSum = 0;
        int currSum ;

        while (i < n / 2) {

            currSum = temp.val + revLLHead.val;

            maxSum = Math.max(currSum, maxSum);
            temp = temp.next;
            revLLHead = revLLHead.next;
            i++;

        }
        return maxSum;
    }
}


