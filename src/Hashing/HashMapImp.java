package Hashing;

import java.util.*;

public class HashMapImp {
    //HashMap is implemented through array of  LinkedLists Internally

    static class HashMap<K,V>{

        private class Node{

            K key;
            V value;

            public Node(K key,V value){

                this.key=key;
                this.value=value;
            }

        }

        private int n;//number of elements/nodes
        private int N;//size of bucket

        LinkedList<Node>[] bucket;

        public HashMap(){
             n=0;
             N=4;
            bucket=new LinkedList[N];
            // Initialising bucket with empty linkedLists
            for(int i=0;i<N;i++){
                bucket[i]=new LinkedList<>();
            }

        }

        //hashFunction for getting hash/bucket index value for key

        private int hashFunction(K key){

            int hash=key.hashCode();

           hash= Math.abs(hash);

           return hash % N;//hash will be 0-N-1

        }

        //searchLL method to search for actual node or data in Map

        private int searchLL(K key,int bi){

            LinkedList<Node>ll=bucket[bi];

            for(int i=0;i<ll.size();i++){

                Node node=ll.get(i);
                if(node.key==key){
                    return i;

                }

            }
            return -1;
        }



        //put method

        public void put(K key,V value){

            double l=(double) n/N;// if load factor is > 0.75 do rehashing

            if(l>0.75){
                reHashing();
            }

           int bi=hashFunction(key);
           int di=searchLL(key,bi);

           if(di!=-1){//if already exists then update

              Node node= bucket[bi].get(di);
              node.value=value;

           }else{//if not exist add a new one

               Node node=new Node(key,value);
               bucket[bi].add(node);
               n++;//increased number of nodes/elements

           }

        }


        public V get(K key){

            int bi=hashFunction(key);
            int di=searchLL(key,bi);

            if(di!=-1){//if  exists return value

                Node node= bucket[bi].get(di);
                return node.value;

            }else{//if not exist return null

                return null;
            }

        }


        public boolean containsKey(K key){

            int bi=hashFunction(key);
            int di=searchLL(key,bi);

            //if  exists return true;
            //if not exist return false
            return di != -1;

        }


        public V remove(K key){

            int bi=hashFunction(key);
            int di=searchLL(key,bi);

            if(di!=-1){//if exists then  remove

                Node node= bucket[bi].remove(di);
                n--;//decreased number of elements
                return node.value;

            }else{//if not exist return null

                return null;

            }

        }


        public Set<K> keySet() {

            Set<K> keySet = new HashSet<>();

            for(int i=0;i<N;i++){

                LinkedList<Node>ll=bucket[i];

                for(Node node:ll){

                    keySet.add(node.key);

                }

            }
            return keySet;
        }


        public void reHashing(){


            LinkedList<Node>[] oldBucket=bucket;
            N=N*2;

            bucket=new LinkedList[N];

            for(int i=0;i<N;i++){

                bucket[i]=new LinkedList<>();

            }

            for(int i=0;i<oldBucket.length;i++){


                for(Node n:oldBucket[i]){//both buckets will be referencing the same bucket nodes /shallow copy

                    put(n.key, n.value);

                }

            }

        }

        public boolean isEmpty(){

            return n==0;//if no elements return true

        }


    }



    public static void main(String[] args) {

       HashMap<String,Integer>hm=new HashMap<>();

        hm.put("India",140);
        hm.put("China",148);
        hm.put("Nepal",16);
        hm.put("US",100);
        hm.put("Australia",50);

        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
        System.out.println(hm.get("China"));
        System.out.println(hm.isEmpty());

        Set<String>keyset=hm.keySet();

        for(String key:keyset){

            System.out.println("["+"Key : "+key +"  | Value : "+hm.get(key)+"]");


        }


    }
}
