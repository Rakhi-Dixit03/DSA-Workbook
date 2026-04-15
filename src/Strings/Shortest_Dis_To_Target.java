package Strings;

public class Shortest_Dis_To_Target {

    public static void main(String[] args) {
        String[] words={"hello","i","am","leetcode","hello"};

        System.out.println("Minimum Distance to Target : "+closestTarget(words,"hello",1));
    }
    public static int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        for (int i = 0; i < n; i++) {

            int  forward = (startIndex+i)%n;
            int backward = (startIndex-i+n)%n;

            if (words[forward].equals(target) || words[backward].equals(target)) {
               return i;
            }


        }
        return -1;
    }

}
