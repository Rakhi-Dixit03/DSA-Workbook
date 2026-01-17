package maths_problems;

public class Largest_Area_Inside_Two_Rectangles {

    public static void main(String[] args) {

        int[][] bottomLeft={{1,1},{1,3},{1,5}};
        int[][] topRight={{5,5},{5,7},{5,9}};

        System.out.println("Largest Area of Square Inside Two Rectangles : "+largestSquareArea(bottomLeft,topRight));

    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int w =
                        Math.min(topRight[i][0], topRight[j][0]) -
                                Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int h =
                        Math.min(topRight[i][1], topRight[j][1]) -
                                Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int side = Math.min(w, h);

                maxSide = Math.max(maxSide, side);
            }
        }

        return maxSide * maxSide;
    }
}

