package Hashing;

import java.util.*;

class Walking_Robot_Simulation {

    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println("Maximum squared Euclidean distance : " + robotSim(commands, obstacles)+" units");
    }

    //T.C. : O(M+N*k)
    //S.C. : O(M) M is number of obstacles
    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();

        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0;
        int y = 0;
        int maxDis = Integer.MIN_VALUE;

        int[] dir = {0, 1};//initially facing north
        for (int command : commands) {

            if (command == -2) {//90 deg left rotation

                int temp = dir[0];
                dir[0] = -dir[1];
                dir[1] = temp;

            } else if (command == -1) {//90 deg right rotation
                int temp = dir[0];
                dir[0] = dir[1];
                dir[1] = -temp;
            } else {

                for (int steps = 0; steps < command; steps++) {
                    //move step by step in current direction
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (set.contains(newX + " " + newY)) {//if obstacle then can't move in that direction
                        break;
                    }

                    x = newX;
                    y = newY;

                }
            }

            maxDis = Math.max(x * x + y * y, maxDis);

        }

        return maxDis;
    }


}

