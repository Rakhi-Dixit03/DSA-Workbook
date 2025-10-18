package LinkedList;

public class Reverse_Nodes_KGroup {

    public static void main(String[] args) {

        Reverse_Nodes_KGroup reverse_kGroups=new Reverse_Nodes_KGroup();

        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));

        ListNode newHead=reverse_kGroups.reverseKGroup(head,2);

        MergeTwoSorted.printLL(newHead);
    }


    public  ListNode reverseKGroup(ListNode head, int k) {

        if(head==null || head.next==null || k==1)return head;


        //Four pointers to keep track of prev,current and next Linked List of K nodes

        ListNode prevTail=null;
        ListNode currHead=head;
        ListNode currTail=head;
        ListNode nextHead=null;

        while(currHead!=null){

            int count=1;//keeping track of k elements in a group(LL)

            while(currTail.next!=null && count<k){

                currTail=currTail.next;
                count++;
            }


            if(count!=k){//we don't have enough elements to form a group
                break;

            }

            //We have found a group(LL)
            //preserving the next LL's head

            nextHead=currTail.next;

            //Detach RHS of the curr LL

            currTail.next=null;

            //Detach LHS  of the curr LL

            if(prevTail!=null){

                prevTail.next=null;

            }

            //Reverse the curr LL
            currTail=reverse(currHead);

            //Attach LHS

            if(prevTail!=null){

                prevTail.next=currTail;

            }else{
                //This is our First LL make it pointed by original head

                head=currTail;
            }


            //Attaching the RHS

            currHead.next=nextHead;

            //Updating the pointers

            prevTail=currHead;
            currHead=nextHead;
            currTail=nextHead;


        }
        return head;

    }

    private ListNode reverse(ListNode head){

        ListNode prev=null;
        ListNode curr=head;
        ListNode nextNode=head;


        while(curr!=null){

            nextNode=nextNode.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;

        }

        return prev;

    }



}
