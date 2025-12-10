package Trie;

import java.util.ArrayList;

public class Prefix_Problem {

    public static class Node{

        Node[] children=new Node[26];
        boolean endOfWord=false;
        int freq=1;


        public Node(){

            for(int i=0;i<26;i++){
                children[i]=null;
            }

        }

    }

     static Node root=new Node();

   public static void insert(String word){

        Node curr=root;

        for(int i=0;i<word.length();i++){

            int idx=word.charAt(i)-'a';

            if(curr.children[idx]==null){

                curr.children[idx]=new Node();

            }else{

                curr.children[idx].freq++;
            }

            //update curr for next level
            curr=curr.children[idx];

        }

        curr.endOfWord=true;

   }


   public static ArrayList<String> findPrefix(String[] words){

       //build Trie
       for (String word : words) {
           insert(word);

       }

      ArrayList<String>ans=new ArrayList<>();
      //finding prefix of each word
       for (String word : words) {

           helper(word, ans);

       }

       return ans;


   }

    public static void helper(String word,ArrayList<String> ans){

       Node curr=root;
       StringBuilder ansStr=new StringBuilder();

       for(int i=0;i<word.length();i++){

           int idx=word.charAt(i)-'a';

           ansStr.append(word.charAt(i));

           if(curr.children[idx]!=null){

              if(curr.children[idx].freq==1)
               break;
           }

           curr=curr.children[idx];
       }

       ans.add(ansStr.toString());


    }




    public static void main(String[] args) {

        String[] word={"zebra","dog","duck","dove"};

        root.freq=-1;

        System.out.println(findPrefix(word));


    }

}
