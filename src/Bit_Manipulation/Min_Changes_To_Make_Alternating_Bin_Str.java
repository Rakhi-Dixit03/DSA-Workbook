package Bit_Manipulation;

public class Min_Changes_To_Make_Alternating_Bin_Str {

    public static void main(String[] args) {
        System.out.println("Minimum Operations required to make Alternating Binary String : "+minOperations("1000100101"));
    }
    public static int minOperations(String s) {

     //Compare the string against two ideal alternating patterns starting with '0' and '1' to find minimum changes.

        int misMatch1=0;
        int misMatch2=0;

        int firstSt=1;//There are only two possibility of starting of a string
        //either by 1 or by 0

        int secSt=0;

        for(char ch : s.toCharArray()){
            int curr=ch-'0';

            if(curr!=firstSt){
                misMatch1++;

            }

            if(curr!=secSt){
                misMatch2++;
            }

            firstSt=firstSt==0?1:0;//Creating Alternating Strings to match with string given in input
            secSt=secSt==0?1:0;

        }

        return Math.min(misMatch1,misMatch2);//returning minimum of two possible cases

    }




}
