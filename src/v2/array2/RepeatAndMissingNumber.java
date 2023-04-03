package v2.array2;

import v2.util.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class RepeatAndMissingNumber {
    private static long actualSum = 0;

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] returnArray = new int[2];
        // Write your code here
        long sum = (n * (n + 1)) / 2;
        int duplicate = findDuplicate(arr);

        actualSum = actualSum - duplicate;
        returnArray[0] = (int) (sum - actualSum);
        returnArray[1] = duplicate;
        return returnArray;

    }


    public static int findDuplicate(ArrayList<Integer> arr) {
        int duplicate = 0;
        for (int i = 0; i < arr.size(); i++) {
            int index = Math.abs(arr.get(i));
            actualSum += index;
            int numberAtIndex = arr.get(index - 1);
            if (numberAtIndex < 0)
                duplicate = index;
            arr.set(index - 1, arr.get(index - 1) * -1);
        }
        return duplicate;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(Arrays.asList(7, 5, 3, 2, 1, 6, 6));
        PrintHelper.printArray(missingAndRepeating(arrayList, 7));
    }
}
