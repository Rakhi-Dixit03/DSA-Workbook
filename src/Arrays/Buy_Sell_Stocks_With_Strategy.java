package Arrays;

public class Buy_Sell_Stocks_With_Strategy {


    public static void main(String[] args) {

        int[] prices={4,2,8};
        int[] strategy={-1,0,1};
        System.out.println("Maximum Profit : "+maxProfit(prices,strategy,2));


    }


    public static long maxProfit(int[] prices, int[] strategy, int k) {

        long totProfit = 0;
        int n = prices.length;
        long[] profit = new long[n];

        for (int i = 0; i < n; i++) {

            profit[i] = (long) prices[i] * strategy[i];
            totProfit+=profit[i];

        }

        long originalP = 0;
        long modP = 0;

        long maxGain = 0;

        int i = 0, j = 0;

        while (j < n) {

            originalP += profit[j];


            if (j - i + 1 > k / 2) {//2nd half of subArray

                modP += prices[j];

            }

            if (j - i + 1 > k) {//shrink the window

                originalP -= profit[i];
                modP -= prices[i + k / 2];
                i++;

            }

            if (j - i + 1 == k) {//Evaluate window of size k

                maxGain = Math.max(maxGain,modP-originalP);

            }

            j++;

        }

        return totProfit + maxGain;

    }

}
