package Strings;
//Ques : 657
public class Robert_Return_To_Origin {

    public static void main(String[] args) {
        System.out.println("Did robert return to Origin ? : "+(judgeCircle("LR")?"Yes":"No"));
    }
    public static boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {

            if (moves.charAt(i) == 'L') {
                x--;
            } else if (moves.charAt(i) == 'R') {
                x++;
            } else if (moves.charAt(i) == 'U') {
                y--;

            } else {
                y++;
            }
        }

        return x == 0 && y == 0;

    }
}
