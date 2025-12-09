package Trie;

import Trie.TrieImpl;

public class Word_Break_Problem {

    public static void main(String[] args) {

        String[] dict={"i","like","sam","samsung","mobile","ice"};
        String key="ilikesamsung";
        String key2="ilikejava";

        System.out.println("Can we Break the key String into words that could be found in the dictionary : "+(wordBreak(dict, key) ?"Yes":"No"));
        System.out.println("Can we Break the key String into words that could be found in the dictionary : "+(wordBreak(dict, key2) ?"Yes":"No"));

    }

    public static boolean wordBreak(String[] words,String key){

        //1. Create a Trie out of words in the dictionary

        for(String word:words){

            TrieImpl.insert(word);
        }

        //2.Try to divide the String into all possible substrings

        return helper(key);

    }

    //Recursive method
    public static boolean helper(String key){
        //Base case

        if(key.isEmpty())return true;

        for(int i=1;i<=key.length();i++){

            if(TrieImpl.search(key.substring(0,i)) && helper(key.substring(i))){

                return true;
            }

        }

        return false;

    }

}
