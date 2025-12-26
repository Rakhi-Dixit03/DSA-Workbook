package Strings;

public class BestTimeToClose {

    public static void main(String[] args) {

        System.out.println("Best Time to Close the Store to minimize penalty : "+bestClosingTime("YYNY"));

    }

    public static int bestClosingTime(String customers) {

        int n = customers.length();
        int[] prefix = new int[n + 1];

        prefix[0] = 0;


        for (int i = 1; i <= n; i++) {

            prefix[i]=prefix[i-1];

            if (customers.charAt(i - 1) == 'N')prefix[i]+=1;


        }

        //Building suffix Array
        int suffix=0;
        for (int i = n - 1; i >= 0; i--) {

            if (customers.charAt(i) == 'Y') {
                suffix++;
            }

            prefix[i]+=suffix;

        }

        int bestClosingTime = -1;//we have to store index of best time
        int penaltySoFar = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            int currPenalty = prefix[i];

            if (currPenalty < penaltySoFar) {

                penaltySoFar = currPenalty;
                bestClosingTime = i; //penalty should be minimum
            }

        }

        return bestClosingTime;
    }


}
