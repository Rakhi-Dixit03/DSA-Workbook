package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {


    public static void main(String[] args) {

       LRU lruCache=new LRU(3);

       //add a value
        lruCache.put(1,5);
        lruCache.put(2,10);

       //Accessing a value

        System.out.println(lruCache.get(1));// 5 will be output
        System.out.println(lruCache.get(2));// 10

        lruCache.put(3,15);//this is going to be recently used

        lruCache.put(4,20);//capacity gets full now ,it will remove LRU value which is 1

        //let's see has it deleted 1

        System.out.println(lruCache.get(1));//returned -1 means (1) removed

        System.out.println(lruCache.get(4));


    }

}


class LRU{

    class Node{

        int key;
        int val;
        Node prev,next;
        public Node(int k,int v){

            key=k;
            val=v;
        }
    }

    private int capacity;
    private Map<Integer,Node>map;
    private Node head,tail;


    public LRU(int capacity){

        this.capacity=capacity;

        map=new HashMap<>();
        head=new Node(0,0);//helper nodes/dummy nodes
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;

    }

    //Methods
    //get Method

    public int get(int key){

        if(!map.containsKey(key)){
            return -1;
        }else{

            Node node=map.get(key);
            remove(node);
            insertToHead(node);//Means... marking it as Recently used Value
            return node.val;
        }

    }


    //put method

    public void put(int key,int value){

        if(map.containsKey(key)){
            //update

            Node node=map.get(key);
            node.val=value;
            //Mark it recently used
            remove(node);
            insertToHead(node);

        }else{

            if(map.size()==capacity){
                //Remove the least recently used value

                Node lru=tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

             //Adding new Node

            Node newNode=new Node(key,value);
            insertToHead(newNode);
            map.put(key,newNode);

        }

    }
   //Helper methods [remove] and [insertToHead]

    private void  remove(Node node){

        node.prev.next=node.next;
        node.next.prev=node.prev;

    }


    private void insertToHead(Node node){

      node.next=head.next;
      node.prev=head;
      head.next.prev=node;
      head.next=node;

    }

}

