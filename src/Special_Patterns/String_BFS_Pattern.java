package Special_Patterns;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class String_BFS_Pattern {


    public static void main(String[] args) {

        String_BFS_Pattern strBFSPatt=new String_BFS_Pattern();
        String ans=strBFSPatt.findLexSmallestString("5525",9,2);
        System.out.println(ans);


    }

    public String findLexSmallestString(String s, int a, int b) {

        Queue<String> q=new LinkedList<>();

        Set<String> vis=new HashSet<>();
        String smallest= s;

        q.offer(s);
        vis.add(s);

        while(!q.isEmpty()){

            String curr=q.poll();

            if(smallest.compareTo(curr)>0){//find a better answer
                smallest=curr;
            }

            //Add ops
            StringBuilder temp =new StringBuilder(curr);

            for(int i=1;i<curr.length();i+=2){

                char ch= (char)((((temp.charAt(i)-'0')+a)%10)+'0');
                temp.setCharAt(i,ch);

            }

            if(vis.add(temp.toString())){

                q.offer(temp.toString());

            }

            //Rotate ops
            StringBuilder temp2 =new StringBuilder(curr);

            rotate(temp2,b);

            if(vis.add(temp2.toString())){
                q.offer(temp2.toString());

            }


        }

        return smallest;

    }


    private void rotate(StringBuilder str,int b){

        str.reverse();
        reverse(str,0,(b));
        reverse(str,(b),str.length());

    }

    private void reverse(StringBuilder str,int st,int end){


        while(st<end){

            char temp=str.charAt(st);

            str.setCharAt(st,str.charAt(end-1));

            str.setCharAt(end-1,temp);

            st++;
            end--;

        }

    }


}
