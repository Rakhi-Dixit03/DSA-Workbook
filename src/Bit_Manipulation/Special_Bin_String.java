package Bit_Manipulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Special_Bin_String {

    public static void main(String[] args) {
        System.out.println("Special Binary String : "+makeLargestSpecial("11011000"));
    }
    public static String makeLargestSpecial(String s) {

        List<String> specials=new ArrayList<>();
        int sum=0;
        int st=0;

        for(int i=0;i<s.length();i++){

            sum+=s.charAt(i)=='1'?1:-1;

            if(sum==0){//we have got special string
                String inner = s.substring(st+1,i);
                specials.add('1'+makeLargestSpecial(inner)+'0');

                st=i+1;

            }
        }

        specials.sort(Comparator.reverseOrder());
        StringBuilder res=new StringBuilder();
        for(String str:specials){
            res.append(str);
        }

        return res.toString();
    }

}
