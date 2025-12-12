package Trie;

public class Count_Unique_SubStrings {

    public static void main(String[] args) {


        System.out.println("Unique SubStrings Count is : "+countUniqueSubStr("ababa"));
//        System.out.println("Unique SubStrings Count is : "+countUniqueSubStr("apple"));//at a time we can execute one



    }
   //Total SubStrings - All prefixes of all Suffixes OR  All Suffixes of All Prefixes
   //Count of Unique SubStrings - count of unique prefixes

    public static int countUniqueSubStr(String str){

        //Build Trie out of Suffixes of String

        for(int i=0;i<str.length();i++){

            TrieImpl.insert(str.substring(i));

        }

        //Count nodes of trie because Trie Stores unique Prefixes

        return countNodes(TrieImpl.root);

    }

    public static int countNodes(TrieImpl.Node root){

        if(root==null){
            return 0;
        }

        int count=0;

        for(int i=0;i<26;i++){

            if(root.children[i]!=null){

             count += countNodes(root.children[i]);

            }

        }

        return count+1;

    }


}
