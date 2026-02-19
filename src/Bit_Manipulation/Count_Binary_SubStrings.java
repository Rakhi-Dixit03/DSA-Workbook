package Bit_Manipulation;

public class Count_Binary_SubStrings {

    public static void main(String[] args) {
        System.out.println("Number of Binary SubStrings : "+countBinarySubstrings("1010111000101"));
    }
    public static int countBinarySubstrings(String s) {
        if(s.length()==1){
            return 0;
        }
        int binSubStrs=0;//keeping count of answer subStrings
        int prevCount=0;//previous streak
        int currCount=1;//current running count

        for(int i=0;i<s.length()-1;i++){

            if(s.charAt(i)==s.charAt(i+1)){
                currCount++;
            }else{

                binSubStrs+=Math.min(prevCount,currCount);//Each one comes from two adjacent groups,
                // and you can only extend up to the smaller group size

                prevCount=currCount;
                currCount=1;
            }

        }

        //last count is not added

        binSubStrs+=Math.min(prevCount,currCount);

        return binSubStrs;
    }


}
