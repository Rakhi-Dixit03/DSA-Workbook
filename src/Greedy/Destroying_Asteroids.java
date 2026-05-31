package Greedy;

//Ques 2126
//TC-O(NLogN)
//Sort asteroids by mass and greedily consume them from smallest to largest to maximize planet growth.
public class Destroying_Asteroids {

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        java.util.Arrays.sort(asteroids); // Sort by mass in ascending order
        long currentMass = mass; // Preventing integer overflow
        for (int asteroid : asteroids) {
            // Traverse the asteroids in order, attempt to destroy and update mass or return the result
            if (currentMass < asteroid) {
                return false;
            }
            currentMass += asteroid;
        }
        return true; // Successfully destroy all asteroids
    }

    public static void main(String[] args) {

        System.out.println("Answer : "+asteroidsDestroyed(10,new int[]{3,9,19,5,21}));
    }
}
