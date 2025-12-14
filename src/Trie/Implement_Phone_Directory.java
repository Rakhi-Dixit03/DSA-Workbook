package Trie;



public class Implement_Phone_Directory {

    public static class Node{

        Node[] children=new Node[26];
        boolean endOfWord=false;

        public Node(){

            for(int i=0;i<26;i++){

                children[i]=null;
            }


        }

    }

    static Node root=new Node();

    public static void main(String[] args) {

        String[] dir={"geeikistest","geeksforeeks","geeksfortest"};
        String s="geeips";

        phoneDirectory(dir,s);

    }


    public static void phoneDirectory(String[] dir,String s){//s here is query string

        boolean noMatch=false;

        for(String p:dir){

            insert(p);//put all contacts in a Trie
        }

        for(int i=1;i<=s.length();i++){

            if (noMatch) {

                System.out.println("0");
                continue;
            }

            noMatch=helper(s.substring(0,i));

        }


    }

    public static boolean helper(String q){

        Node curr=root;
        //search the query string



        for(int i=0;i<q.length();i++){

            int idx=q.charAt(i)-'a';

            if(curr.children[idx]==null){

                System.out.println("0");
                return true;


           }
            curr=curr.children[idx];

        }

        dfs(curr,new StringBuilder(q));
        return false;

    }

    public static void dfs(Node root,StringBuilder temp){

        if(root.endOfWord){
            System.out.println(temp.toString());

        }

        for(int i=0;i<26;i++){

            if(root.children[i]!=null){

                temp.append((char)(i+'a'));

                dfs(root.children[i],temp);

                //backtrack
                temp.deleteCharAt(temp.length()-1);

            }


        }


    }




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

}
