package BinarySearch;

public class Min_Initial_Energy_To_Finish_Tasks {

    //TC- Sorting: O(n log n)
    //Binary search: O(log 1e9) ≈ 31
    //Each check: O(n)
    //O(n log n + n * 31)

    boolean isPossible(int[][] tasks, int mid) {

        int remainingEnergy = mid;
        for (int[] task : tasks) {

            int reqInitialEnergy = task[1];
            int actualEnergyNeed = task[0];

            if (reqInitialEnergy > remainingEnergy) {
                return false;
            }

            remainingEnergy -= actualEnergyNeed;

        }

        return true;

    }

    public int minimumEffort(int[][] tasks) {

        int l = 1;
        int r = 1_000_000_000;

        int minEnergy = 0;

        //Sort Tasks based on difference between [minEnergy-actualEnergy]

        java.util.Arrays.sort(tasks, (a, b) -> {

            int diff1 = a[1] - a[0];//first task
            int diff2 = b[1] - b[0];//second task

            return Integer.compare(diff2, diff1);

        });

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (isPossible(tasks, mid)) {
                minEnergy = mid;
                r = mid - 1;//Left side for smaller values of energies
            } else {
                l = mid + 1;//Right side - bigger values of energies
            }

        }
        return minEnergy;
    }

    public static void main(String[] args) {

        Min_Initial_Energy_To_Finish_Tasks obj=new Min_Initial_Energy_To_Finish_Tasks();
        int[][] tasks={{1,2},{2,4},{4,8},{8,16}};

        System.out.println("Minimum Initial Energy required to complete the tasks is : "+obj.minimumEffort(tasks));
    }

}
