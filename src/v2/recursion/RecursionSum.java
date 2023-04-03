package v2.recursion;

import java.util.ArrayList;

public class RecursionSum {

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        if (N == 0) {
            ArrayList<Integer> sumList = new ArrayList<>();
            sumList.add(0);
            return sumList;
        }
        ArrayList<Integer> sumList = subsetSums(arr, N - 1);
        int curr = arr.size() - N;
        int len = sumList.size();
        for (int i = 0; i < len; i++) {
            sumList.add(arr.get(curr) + sumList.get(i));
        }
        return sumList;
    }
}
