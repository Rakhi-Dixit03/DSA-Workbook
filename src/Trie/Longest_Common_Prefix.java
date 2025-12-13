package Trie;

public class Longest_Common_Prefix {

    public static void main(String[] args) {
        String[] words={"flower","flow","flown"};
        String ans=longestCommonPrefix(words);

        if(ans.isEmpty()){
            System.out.println("No common prefix exists.");

        }else{
            System.out.println("Longest Common Prefix found is : "+ans);
        }

    }


    public static String longestCommonPrefix(String[] words){

        int n= words.length;
        //Build Trie Out of Words Array
        for(String word:words){

            Prefix_Problem.insert(word);

        }

       StringBuilder ans=new StringBuilder();

        helper(Prefix_Problem.root,ans,n);

        return ans.toString();
    }

    public static void helper(Prefix_Problem.Node root,StringBuilder ans,int n){


        for(int i=0;i<26;i++){

            if(root.children[i]!=null){

                if(root.children[i].freq!=n){
                    return;
                }else{

                    ans.append((char)(i+'a'));
                    helper(root.children[i],ans,n);

                }


            }

        }


    }

}
