package dynamicProgramming;

public class Min_Distance_To_Type_A_Word {

    Integer[][][] memo=new Integer[301][27][27];//ith character ,f1 and f2

    public static void main(String[] args) {
        Min_Distance_To_Type_A_Word obj=new Min_Distance_To_Type_A_Word();
        System.out.println("Minimum Distance to Type a word using two fingers : "+obj.minimumDistance("HELLO"));
    }
    int[] getCoordinate(int curr) {

        return new int[] { curr / 6, curr % 6 };

    }

    int getDis(int f, int curr) {

        int[] coordinateF = getCoordinate(f);
        int[] coordinateCurr = getCoordinate(curr);

        return Math.abs(coordinateF[0] - coordinateCurr[0]) + Math.abs(coordinateF[1] - coordinateCurr[1]);

    }

    public int minimumDistance(String word) {
        return solve(word, 0, 26, 26);
    }

    int solve(String word, int i, int f1, int f2) {

        if (i >= word.length()) {
            return 0;
        }

        if(memo[i][f1][f2]!=null){
            return memo[i][f1][f2];
        }
        int curr = word.charAt(i) - 'A';
        if (f1 == 26 && f2 == 26) {//Both fingers are not Used 

            return memo[i][f1][f2]=solve(word, i + 1, curr, f2);
        }

        if (f2 == 26) {//F2 is not used 

            int moveF2 = solve(word, i + 1, f1, curr);
            int moveF1 = getDis(f1, curr) + solve(word, i + 1, curr, f2);
            return memo[i][f1][f2]=Math.min(moveF1, moveF2);
        }

        //Both fingers are used 

        int moveF1 = getDis(f1, curr) + solve(word, i + 1, curr, f2);
        int moveF2 = getDis(f2, curr) + solve(word, i + 1, f1, curr);
        return memo[i][f1][f2]= Math.min(moveF1, moveF2);

    }
    
    
    
}
