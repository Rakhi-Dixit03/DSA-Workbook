package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group_Anagrams_Together {

    static class Node{

        Node[] children =new Node[26];
        boolean endOfWord;
        List<String> list;

        public Node(){

            endOfWord=false;
            list=new ArrayList<>();

            for(int i=0;i<26;i++){

                children[i]=null;

            }

        }


    }

    static Node root=new Node();

    public static void main(String[] args) {

        String[] words={"tea","eat","tan","ate","nat","bat"};

        System.out.println("Grouped Anagrams are : "+groupAnagrams(words));


    }



    public static List<List<String>> groupAnagrams(String[] words){

        //First Build Trie Out of words

        for(String word:words){

            build(word);

        }

        List<List<String>>ans=new ArrayList<>();
        //it will collect all anagrams stored in the leaf node of each anagram string
        dfs(root,ans);

        return ans;

    }

    //Build Method for Building  Trie
    public static void build(String word){

        //Sort Word
        char[] sortedWord=word.toCharArray();

        Arrays.sort(sortedWord);

        Node curr=root;

        for (char ch : sortedWord) {

            int idx = ch - 'a';

            if (curr.children[idx] == null) {

                curr.children[idx] = new Node();

            }

            //Already a character exists

            curr=curr.children[idx];

        }

        //make eow=true
        curr.endOfWord=true;
        curr.list.add(word);


    }
    //Traversing the Trie to get lists of anagrams
    public static void dfs(Node root,List<List<String>>ans){

        if(root.endOfWord){

            ans.add(root.list);
        }

        for(int i=0;i<26;i++){

            if(root.children[i]!=null){

                dfs(root.children[i],ans);

            }


        }


    }



}
