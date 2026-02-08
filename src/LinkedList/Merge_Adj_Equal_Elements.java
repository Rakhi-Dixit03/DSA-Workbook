package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Merge_Adj_Equal_Elements {

    public static void main(String[] args) {
        System.out.println("After Merge : "+mergeAdjacent(new int[]{7,7,2,4,4,2,7,3,3}));
    }

    static class Node{

        long data;
        Node prev;
        Node next;
        public Node(long data,Node p,Node n){
            this.data=data;
            prev=p;
            next=n;
        }

    }
        public static List<Long> mergeAdjacent(int[] nums) {

            int n=nums.length;
            List<Long>ans=new ArrayList<>();

            if(n==1){
                ans.add((long)nums[0]);
                return ans;
            }

            Node head=new Node(0,null,null);

            Node temp=head;

            for (int num : nums) {

                Node nNode = new Node(num, temp, null);
                temp.next = nNode;
                temp = nNode;

            }

            Node curr=head;

            while(curr!=null){

                if(curr.next!=null && curr.data==curr.next.data){

                    curr.data=curr.data+curr.next.data;

                    if(curr.next.next!=null){
                        curr.next=curr.next.next;
                        curr.next.prev=curr;
                    }else{
                        curr.next=null;
                    }

                    //after changing

                    if(curr.prev!=null && curr.prev.data==curr.data){
                        curr=curr.prev;

                    }

                }else{
                    curr=curr.next;
                }


            }

            temp=head.next;
            while(temp!=null){

                ans.add(temp.data);
                temp=temp.next;

            }

            return ans;
        }
    }