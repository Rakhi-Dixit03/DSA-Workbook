package Special_Patterns;

public class Min_Moves_To_Make_Arr_Complementary {

    public int minMoves(int[] numbers, int limit) {
        // Create a difference array to track move costs for each possible sum
        // Size is 2*limit+2 to handle all possible sums from 2 to 2*limit
        int[] differenceArray = new int[2 * limit + 2];
        int arrayLength = numbers.length;

        // Process each pair (numbs[i], numbs[n-i-1])
        for (int i = 0; i < arrayLength / 2; ++i) {
            // Get the smaller and larger values of the current pair
            int minValue = Math.min(numbers[i], numbers[arrayLength - i - 1]);
            int maxValue = Math.max(numbers[i], numbers[arrayLength - i - 1]);

            // For sum in range [2, minValue]: need 2 moves (change both elements)
            differenceArray[2] += 2;
            differenceArray[minValue + 1] -= 2;

            // For sum in range [minValue+1, minValue+maxValue-1]: need 1 move
            differenceArray[minValue + 1] += 1;
            differenceArray[minValue + maxValue] -= 1;

            // For sum = minValue+maxValue: need 0 moves (already equals this sum)
            differenceArray[minValue + maxValue] += 1;
            differenceArray[minValue + maxValue + 1] -= 1;

            // For sum in range [minValue+maxValue+1, maxValue+limit]: need 1 move
            // (Already handled by the previous difference array updates)

            // For sum in range [maxValue+limit+1, 2*limit]: need 2 moves
            differenceArray[maxValue + limit + 1] += 2;
        }

        // Calculate the minimum moves by computing prefix sum
        int minimumMoves = arrayLength;
        int prefixSum = 0;

        // Check each possible target sum from 2 onwards
        for (int targetSum = 2; targetSum < differenceArray.length; ++targetSum) {
            prefixSum += differenceArray[targetSum];
            minimumMoves = Math.min(minimumMoves, prefixSum);
        }

        return minimumMoves;
    }
}



