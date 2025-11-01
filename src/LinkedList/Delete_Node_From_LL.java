package LinkedList;

import java.util.Set;
import java.util.stream.Collectors;

public class Delete_Node_From_LL {


    public static void main(String[] args) {

        int[] nums={1,2,3};
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));

       ListNode h= modifiedList(nums,head);

        MergeTwoSorted.printLL(h);

        System.out.println();

        ListNode head1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));

        ListNode h1=modifiedList2(nums,head1);

        MergeTwoSorted.printLL(h1);



    }

    public  static ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> set=java.util.Arrays.stream(nums).boxed().collect(Collectors.toSet());


        ListNode temp=head;
        ListNode prev=null;

        while(temp!=null){

            if(set.contains(temp.val)){

                if(prev==null){//means temp is head node

                    temp=temp.next;
                    head=temp;

                }else{

                    prev.next=temp.next;
                    temp=temp.next;

                }

            }else{

                prev=temp;
                temp=temp.next;

            }

        }

        return head;

    }


    public static ListNode modifiedList2(int[] nums,ListNode head){

        Set<Integer>set=java.util.Arrays.stream(nums).boxed().collect(Collectors.toSet());
      //handle head

        while(set.contains(head.val) && head!=null){

            head=head.next;

        }

        ListNode curr=head;

        while(curr!=null && curr.next!=null){

            if(set.contains(curr.next.val)){

                curr.next=curr.next.next;


            }else{
                curr=curr.next;
            }

        }

        return head;

    }

}
