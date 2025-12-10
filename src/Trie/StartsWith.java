package Trie;

import static Trie.TrieImpl.root;

public class StartsWith {

    public static void main(String[] args) {

        String[] words={"apple","mango","app","man","woman"};

        String prefix="app";
        String prefix2="moon";

        System.out.println("Does prefix exists in words dictionary : "+startWith(words,prefix));
        System.out.println("Does prefix exists in words dictionary : "+startWith(words,prefix2));


    }


    public static boolean startWith(String[] words,String prefix){

        //Build a Trie

        for(String word:words){

            TrieImpl.insert(word);
        }

        //Now Searching for the prefix
        TrieImpl.Node curr = root;

        for(int i=0;i<prefix.length();i++){

            int idx=prefix.charAt(i)-'a';

            if(curr.children[idx]==null){

                return false;

            }

            curr=curr.children[idx];

        }

        return true;
    }

}
