package Bit_Manipulation;

public class Partitioning_into_Min_Number_Deci_Bin_Num {

    public static void main(String[] args) {
        System.out.println("Partitioning into Minimum Number of Decimal Binary Number : "+minPartitions("32"));
    }

    public static int minPartitions(String n) {
        int ans=0;
        for(char ch='9';ch>='0';ch--){

            if(n.indexOf(ch)!=-1){
                ans=ch-'0';
                break;
            }

        }
        return ans;
    }


}
