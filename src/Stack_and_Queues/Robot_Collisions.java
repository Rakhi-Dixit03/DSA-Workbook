package Stack_and_Queues;
//Ques : 2751

import java.util.*;

class Pair {
    int robo;
    int pos;

    Pair(int r, int p) {
        robo = r;
        pos = p;
    }

    public int getPos() {
        return pos;
    }
}

public class Robot_Collisions {

    public static void main(String[] args) {
        System.out.println("Survived Robots' Health  : " + survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        List<Integer> ans = new ArrayList<>();
        List<Pair> roboPosList = new ArrayList<>();
        Comparator<Pair> comp = Comparator.comparing(Pair::getPos);

        for (int i = 0; i < n; i++) {
            roboPosList.add(new Pair(i, positions[i]));

        }

        roboPosList.sort(comp);

        Stack st = new Stack();

        for (int i = 0; i < n; i++) {

            Pair curr = roboPosList.get(i);
            int robo = curr.robo;

            char dir = directions.charAt(robo);

            while (!st.isEmpty() && directions.charAt(st.peek()) == 'R' && dir == 'L') {

                //Process by pos in increasing order
                if (healths[robo] == healths[st.peek()]) {
                    st.pop();
                    healths[robo] = 0;
                    break;
                } else if (healths[robo] > healths[st.peek()]) {
                    st.pop();
                    healths[robo] = healths[robo] - 1;


                } else {

                    healths[st.peek()] -= 1;
                    healths[robo] = 0;
                    break;

                }
            }
            if (healths[robo] > 0) {
                st.push(robo);
            }

        }

        List<Integer> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());

        }

        Collections.sort(list);
        for (Integer i : list) {

            ans.add(healths[i]);

        }

        return ans;

    }

}


