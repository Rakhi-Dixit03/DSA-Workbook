package maths_problems;

//Ques : 3300
//TC-O(NlogM)
public class Min_Ele_After_Replacement {

    static int getSum(int num) {

        String strNum = String.valueOf(num);
        int sum = 0;

        for (int i = 0; i < strNum.length(); i++) {
            char ch = strNum.charAt(i);

            int digit = ch - '0';
            sum += digit;

        }

        return sum;

    }

    public static int minElement(int[] numbers) {

        int minEle = Integer.MAX_VALUE;

        for (int num : numbers) {

            int currEleSum = getSum(num);
            minEle = Math.min(currEleSum, minEle);

        }
        return minEle;
    }

    public static void main(String[] args) {
        System.out.println("Minimum Element After replacement with digit sum is : "
                + minElement(new int[]{12, 43, 65, 10, 46}));
    }


}
