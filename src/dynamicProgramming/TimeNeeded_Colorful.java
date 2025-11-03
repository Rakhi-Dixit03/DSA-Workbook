package dynamicProgramming;

//Minimum Time Needed to make rope colorful
public class TimeNeeded_Colorful {


    public static void main(String[] args) {

        String colors="aabaa";
        int[] neededTime={1,2,3,4,1};

        System.out.println("Minimum Time Needed to Make Rope Colorful is : "+minCost(colors,neededTime));

    }


    public static int minCost(String colors, int[] neededTime) {

        int n=colors.length();
        int[] dp=new int[n];
        //dp[i] will store min time s.t. rope is still colorful


        for(int i=1;i<colors.length();i++){



            if(colors.charAt(i)!=colors.charAt(i-1)){

                dp[i]=dp[i-1];

            }else{

                dp[i]=dp[i-1]+Math.min(neededTime[i],neededTime[i-1]);
                neededTime[i]=Math.max(neededTime[i],neededTime[i-1]);

            }

        }

        return dp[n-1];

    }



}
