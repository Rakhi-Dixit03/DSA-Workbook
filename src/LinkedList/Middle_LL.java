package LinkedList;

public class Middle_LL {

    public static void main(String[] args) {

        Linkedlist list=new Linkedlist();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Value found : "+middleElement(list.head));


    }

    //Hare and Tortoise Approach/Two pinter approach
    public static int middleElement(Node head){

        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

        }

       return slow.data;

    }
}
