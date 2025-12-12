package Trie;

public class Longest_Word_With_All_Prefixes {


    public static void main(String[] args) {

        longestWordWithPrefixes(new String[]{"a","app","ap","appl","apple","apply","banana"});

        System.out.println("Longest Word with All Prefixes is : "+ans);


    }

    static   String ans="";
    public static void longestWordWithPrefixes(String[] words){
        //We know that Trie Stores unique Prefixes
        //Pattern to observe- if a word's all prefixes will exist in dict. then at each of its character there will be endOfWord=True

        //Build Trie out of Words Dictionary

        for(String word : words){

            TrieImpl.insert(word);
        }

        //call helper(Recursive) method

         helper(TrieImpl.root,new StringBuilder());

    }
    //As we are processing children from a-z(0-25) so we will get lexicographically small string as our answer
    //if we want to have lexicographically large string then can reverse the order of processing going from (25-0)z-a

    public static void helper(TrieImpl.Node root,StringBuilder temp){

        for(int i=0;i<26;i++){

            if(root.children[i]!=null && root.children[i].endOfWord){//end of word indicates that word exists in dict.

                char ch=(char)(i+'a');
                temp.append(ch);

                if(temp.length()>ans.length()){

                    ans=temp.toString();

                }

                //recursive call to method for next level's character

                helper(root.children[i],temp);

                //backtrack
                temp.deleteCharAt(temp.length()-1);//removing last added character to explore other possible answers

            }


        }
    }

}
