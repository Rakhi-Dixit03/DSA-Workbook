package Arrays;

public class Number_Smooth_Periods {

    public static void main(String[] args) {

        int[] arr={3,2,1,3,2,1,7};
        System.out.println("Number of smooth descent periods is : "+getDescentPeriods(arr));
        System.out.println("Number of smooth descent periods is : "+getDescentPeriods2(arr));

    }

    //Sliding Window/Two Pointers
    public static long getDescentPeriods(int[] prices) {

        long ans = 0;
        int n = prices.length;

        int i=0,j=1;

        while(j<n){

            if(prices[j-1]-prices[j]!=1){

                int eleCount=j-i;
                ans=ans+((long)eleCount*(eleCount+1))/2;

                //update i
                i=j;

            }

            j++;

        }

        //handling last element contribution

        int eleCount=j-i;
        ans=ans+((long)eleCount*(eleCount+1))/2;

        return ans;
    }


    public static long getDescentPeriods2(int[] prices) {

        long ans=1;
        int n=prices.length;

        long smooth=1;

        for(int i=1;i<n;i++){

            if(prices[i-1]-prices[i]==1){
                smooth++;
            }else{

                smooth=1;
            }

            ans+=smooth;

        }
        return ans;

    }

}
