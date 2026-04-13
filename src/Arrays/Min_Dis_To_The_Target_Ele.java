package Arrays;

public class Min_Dis_To_The_Target_Ele {

    public static void main(String[] args) {
        System.out.println("Minimum Distance to the target Element : "+getMinDistance(new int[]{1,3,2,4,5,6,7,5,3,5,9},5,0));
    }

    public static int getMinDistance(int[] numbers, int target, int start) {

        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {

                minDis = Math.min(minDis, Math.abs(start - i));

            }
        }
        return minDis;
    }

}
