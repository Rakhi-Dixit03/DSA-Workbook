package Hashing;

import java.util.*;

public class Sort_By_Frequency {

    public static void main(String[] args) {


        System.out.println("String After Sorting : "+frequencySort("Aabb"));
        System.out.println("String After Sorting : "+frequencySort("tree"));

    }

    //O(NLog(N))

    public static String frequencySort(String s) {

        Map<Character,Integer> freq=new HashMap<>();

        for(char ch:s.toCharArray()){

            freq.put(ch,freq.getOrDefault(ch,0)+1);

        }

        //Max-Heap because we need character in decreasing order of their frequency

        PriorityQueue<Map.Entry<Character,Integer>>pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        //storing entries of map in priority queue

        pq.addAll(freq.entrySet());

        StringBuilder result=new StringBuilder();
        while(!pq.isEmpty()){

            Map.Entry<Character,Integer> entry=pq.poll();

            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));

        }

        return result.toString();

    }


}
