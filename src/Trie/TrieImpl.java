package Trie;

public class TrieImpl {
//what is a Trie?
//It's a Tree Like data Structure ,Used to solve String related problems
//Also called Prefix-Tree or Digital-search-tree
//Unlike Binary Tree it is k-ary tree,means having k children of a node


    //Node Structure of a Trie

    public static class Node{

        Node[] children=new Node[26];//a-z ,if we have to store all characters then we will take a 256 sized array to cover all chars
        boolean endOfWord=false;

        public Node(){

            for(int i=0;i<26;i++){

                children[i]=null;
            }


        }

    }

    public static Node root=new Node();//root will be always empty

    //insert Method

    public static void insert(String word){

        Node curr=root;
        for(int level=0;level<word.length();level++){

            int idx=word.charAt(level)-'a';//index of that character in array

            if(curr.children[idx]==null){
                //create a new  Node to store char
                curr.children[idx]=new Node();

            }

            //update current to traverse over trie level by level
            curr=curr.children[idx];


        }
        //mark last character as endOfWord

        curr.endOfWord=true;

    }

    //Search Method


    public static boolean search(String key){

        Node curr=root;

        for(int level=0;level<key.length();level++){

            int idx=key.charAt(level)-'a';

            if(curr.children[idx]==null){
                return false;
            }


            curr=curr.children[idx];

        }

        return curr.endOfWord;
    }


    public static void main(String[] args) {

        String[] words={"tree","three","the","a","any","apple"};//dealing with lowercase letters only

        //inserting String words into Trie

        for (String word : words) {
            insert(word);

        }

        System.out.println("Search result for tree in the Trie is : "+search("tree"));//True
        System.out.println("Search result for apple in the Trie is : "+search("apple"));//True
        System.out.println("Search result for bingo in the Trie is : "+search("bingo"));//False

    }

}
