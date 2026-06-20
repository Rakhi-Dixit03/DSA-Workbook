package maths_problems;

import java.util.Comparator;

public class Max_Building_Height {

    public static int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        int[][] arr = new int[m + 2][2];

        System.arraycopy(restrictions, 0, arr, 0, m);

        arr[m] = new int[]{1, 0};

        arr[m + 1] = new int[]{n, n - 1};

        java.util.Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int size = arr.length;

        for (int i = 1; i < size; i++) {
            int dist = arr[i][0] - arr[i - 1][0];

            arr[i][1] = Math.min(
                    arr[i][1],
                    arr[i - 1][1] + dist
            );
        }

        for (int i = size - 2; i >= 0; i--) {
            int dist = arr[i + 1][0] - arr[i][0];

            arr[i][1] = Math.min(
                    arr[i][1],
                    arr[i + 1][1] + dist
            );
        }

        long ans = 0;

        for (int i = 1; i < size; i++) {
            long x1 = arr[i - 1][0];
            long h1 = arr[i - 1][1];

            long x2 = arr[i][0];
            long h2 = arr[i][1];

            long dist = x2 - x1;

            long peak =
                    Math.max(h1, h2) +
                            (dist - Math.abs(h1 - h2)) / 2;

            ans = Math.max(ans, peak);
        }

        return (int) ans;
    }

    public static void main(String[] args) {

       int[][] restrictions={{5,3},{2,5},{7,4},{10,3}};
        System.out.println("Maximum Building Height is : "+maxBuilding(10,restrictions));

    }
}


