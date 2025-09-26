package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println("Groups of Anagram Strings are : "+groupAnagram(strs).toString());
    }

    public static List<List<String>> groupAnagram(String[] strs ){

        // Overall TC-O(N*klogk)
        //O(N*K)
        Map<String,List<String>> map=new HashMap<>();

        for(String str:strs){//O(N)

            char[] arr=str.toCharArray();//O(k)
            java.util.Arrays.sort(arr);//O(KLogK) dominates
            String key=new String(arr);//O(K)

            if(!map.containsKey(key)){

                map.put(key,new ArrayList<>());

            }

            map.get(key).add(str);

        }
        return new ArrayList<>(map.values());
    }

}
