package Design;

import java.util.*;
//Ques : 2069
public class Walking_Robot_Simulation2 {

    static class Pair {
        int x;
        int y;
        int d;

        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) {

         Robot obj = new Robot(6, 3);
         obj.step(2);
         obj.step(2);
         int[] pos = obj.getPos();
         System.out.println("Current Position  : "+pos[0]+","+pos[1]);
         String dir = obj.getDir();
         System.out.println("Curr Direction : "+dir);

    }
    static class Robot {

        List<Pair> pos = new ArrayList<>();
        boolean moved = false;
        int idx = 0;

        public Robot(int width, int height) {

            pos.add(new Pair(0, 0, 3));//0-East,1-North,2-East,3-South

            //Left to Right
            for (int x = 1; x < width; x++) {
                pos.add(new Pair(x, 0, 0));
            }

            //bottom to up
            for (int y = 1; y < height; y++) {
                pos.add(new Pair(width - 1, y, 1));
            }

            // Right to Left
            for (int x = width - 2; x >= 0; x--) {
                pos.add(new Pair(x, height - 1, 2));
            }

            //top to bottom
            for (int y = height - 2; y > 0; y--) {
                pos.add(new Pair(0, y, 3));
            }

        }

        public void step(int num) {

            moved = true;
            idx = (idx + num) % pos.size();

        }

        public int[] getPos() {

            return new int[]{pos.get(idx).x, pos.get(idx).y};

        }

        public String getDir() {

            if (!moved) {
                return "East";
            }

            if (pos.get(idx).d == 0) {
                return "East";
            } else if (pos.get(idx).d == 1) {
                return "North";
            } else if (pos.get(idx).d == 2) {
                return "West";
            }

            return "South";

        }
    }

}
