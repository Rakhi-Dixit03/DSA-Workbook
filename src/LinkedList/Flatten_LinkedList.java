package LinkedList;

import java.util.Stack;

public class Flatten_LinkedList {

  public static class Node {

        int data;
        Node next;
        Node child;
        Node prev;


        public Node(int data) {
            this.data = data;
            this.next = null;
            this.child=null;
            this.prev=null;
        }

       public Node(int data, Node next) {
           this.data = data;
           this.next = next;
       }

       public Node(int data, Node child, Node next) {
           this.data = data;
           this.next = next;
           this.child=child;
           this.prev=null;
       }

    }

    public static void main(String[] args) {

        Node head=new Node(1,new Node(2,
                new Node(3,new Node(6,new Node(11,new Node(12,new Node(13)))),
                        new Node(4,new Node(5,new Node(7),new Node(8))))));

            printLL(flatten(head));
            System.out.println();
            printLL(flattenList(head));


    }
        public static Node flatten(Node head) {
            if(head==null)return null;

            Node curr=head;

            while(curr!=null){

                //case- 1 : curr has no child

                if(curr.child==null){
                    curr=curr.next;
                    continue;
                }


                //case - 2 : curr has a child

                    Node temp=curr.child;
                    //Finding out tail of subList/child list

                    while(temp.next!=null){

                        temp=temp.next;
                    }

                    //tail connection
                    temp.next=curr.next;

                    if(curr.next!=null){
                        curr.next.prev=temp;
                    }

                    //head connection

                    curr.next=curr.child;
                    curr.child.prev =curr;

                    //Making child of curr null
                    curr.child=null;

                    curr=curr.next;

                }

            return head;

        }

        //Using stack + DFS
        public static Node flattenList(Node head){

            if(head==null)return null;

            Stack<Node> st=new Stack<>();

            Node curr=head;

            while(curr!=null){
                //Curr has a child
                if(curr.child!=null){

                    if(curr.next!=null) st.push(curr.next);

                    //modifying pointers
                    curr.next=curr.child;
                    curr.child.prev=curr;
                    curr.child=null;

                    //sublist/childList ends
                }else if(curr.next==null && !st.isEmpty()){

                    Node x=st.pop();
                    curr.next=x;
                    x.prev=curr;
                }
                curr=curr.next;
            }

            return head;
        }


    public static void printLL(Node head){

        Node temp=head;
        while(temp!=null){

            System.out.print(temp.data+" ");
            temp=temp.next;

        }

    }

    }

