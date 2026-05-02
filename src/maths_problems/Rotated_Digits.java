package maths_problems;

// Ques : 788
public class Rotated_Digits {
    int[] t;
    //TC - O(N)
    //SC - O(N)
    //Recursion + Memoization Solution
    int solve(int num){

        if(num==0){//Base Case
            return 0;

        }

        if(t[num]!=-1){
            return t[num];
        }

        int remain=solve(num/10);//sub-Problem

        int ld=num%10;

        int digitCheck=0;// 0 - means no change

        if (ld == 5 || ld == 2 || ld == 6 || ld == 9) {
            digitCheck=1;// 1 -  means good
        } else if (ld == 3 || ld == 4 || ld == 7) {
            digitCheck=2;// 2 - means invalid

        }


        if(remain==0 && digitCheck==0){
            return t[num] = 0;
        }else if(remain ==2 || digitCheck==2){
            return t[num] = 2;
        }

        return t[num] = 1;


    }




    //This is Maths + Simulation Solution
    boolean isGoodNum(int num) {

        boolean isValid = true;
        boolean canChange = false;

        while (num > 0) {

            int ld = num % 10;

            if (ld == 5 || ld == 2 || ld == 6 || ld == 9) {
                canChange = true;
            } else if (ld == 3 || ld == 4 || ld == 7) {
                isValid = false;
                break;
            }

            num=num/10;
        }

        return isValid && canChange;
    }

    public int rotatedDigits(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {

            if (isGoodNum(i)) {
                count++;

            }

        }
        return count;
    }



    public static void main(String[] args) {

        Rotated_Digits obj =new Rotated_Digits();

        System.out.println("Number of Good Integers are : "+obj.rotatedDigits(10));

    }


}
