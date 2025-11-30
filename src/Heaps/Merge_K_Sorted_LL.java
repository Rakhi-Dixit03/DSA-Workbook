package Heaps;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
public class Merge_K_Sorted_LL {

     static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {

       ListNode l1=new ListNode(1,new ListNode(2,new ListNode(3)));
       ListNode l2=new ListNode(5,new ListNode(7,new ListNode(10)));
       ListNode l3=new ListNode(-1,new ListNode(0));

       ListNode[] arr={l1,l2,l3};

       ListNode newHead= mergeKLists(arr);

       ListNode curr=newHead;
        System.out.println("Merged List Data : ");
       while(curr!=null){

           System.out.print(curr.val+"  ");
           curr=curr.next;
       }


    }


    public static ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0)return null;

        if(lists.length==1)return lists[0];

        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        int k=lists.length;

        PriorityQueue<ListNode>pq=new PriorityQueue<>(Comparator.comparingInt(a->a.val));

        for(int i=0;i<k;i++){

            if(lists[i]!=null){

                pq.offer(lists[i]);

            }



        }

        while(!pq.isEmpty()){

            ListNode curr=pq.poll();//smallest element

            prev.next=curr;
            prev=prev.next;//updating prev

            if(curr.next!=null){

                pq.add(curr.next);

            }


        }

        return dummy.next;

    }


}
