package Strings;

//TC-O(N)
public class Furthest_Point_From_Origin {

    public static void main(String[] args) {

        System.out.println("Furthest Point from the Origin is : "+furthestDistanceFromOrigin("L__R_LL__"));
    }
    public static int furthestDistanceFromOrigin(String moves) {

        int spaces = 0;
        int movesCount = 0;

        for (int i = 0; i < moves.length(); i++) {

            if (moves.charAt(i) == 'L') {
                movesCount--;
            } else if (moves.charAt(i) == 'R') {
                movesCount++;

            } else {
                spaces++;
            }

        }

        return Math.abs(movesCount) + spaces;

    }



}
