package Stack_and_Queues;

import LinkedList.Linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Finding the index of  first unique character in a String
public class First_Unique_Char {

    public static void main(String[] args) {

        String str="leetcode";
        String str2="lleettv";

        System.out.println(uniqueCharIdx(str));
        System.out.println(uniqueCharIdx2(str));


    }

    public static int uniqueCharIdx(String str){

        int[] countArr=new int[26];//Storing only lowercase English letters

        for(int i=0;i<str.length();i++){

            //Building freq arr
            countArr[str.charAt(i)-'a']++;

        }

        for(int i=0;i<str.length();i++){

           if(countArr[str.charAt(i)-'a']==1){
               return i;

           }

        }
        return -1;
    }

    //Using Queue
    public static int uniqueCharIdx2(String str){

        java.util.Queue<Integer>q=new LinkedList<>();
        Map<Character,Integer> map=new HashMap<>();

         q.add(0);
        for(int i=0;i<str.length();i++){
            //Building freq map
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);

            if(i > 0 && str.charAt(i) != str.charAt(i - 1)){//when a character seen for the first time store index
                q.add(i);
            }


        }

        while(!q.isEmpty()){

            char ch=str.charAt(q.peek());

            if(map.get(ch)==1){
                return (int)q.peek();
            }else{
                q.poll();
            }

        }
       return -1;
    }
}
