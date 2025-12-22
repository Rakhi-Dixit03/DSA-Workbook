package dynamicProgramming;

import java.util.Arrays;

//LCode 960
public class Delete_Cols_To_Make_Sorted3 {


    public static void main(String[] args) {

        String[] strs={"babca","bbazb"};
        System.out.println("minimum Deletions to make input sorted : "+minDeletionSize(strs));

    }


    public static int minDeletionSize(String[] strs) {

        int m=strs[0].length();

        int[] dp = new int[m];

        Arrays.fill(dp,1);//initialising with 1 on all places

        int maxLIS=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){

                boolean safe=true;

                for (String str : strs) {

                    if (str.charAt(j) > str.charAt(i)) {//invalid
                        safe = false;
                        break;
                    }

                }

                if(safe){

                    dp[i]=Math.max(dp[i],dp[j]+1);

                }

            }

            maxLIS=Math.max(maxLIS,dp[i]);

        }



        return m-maxLIS;
    }


}
