package v2.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        combinationSumRec(0, candidates, target, ansList, new ArrayList<>());
        return ansList;
    }

    public void combinationSumRec(int index, int[] candidates, int target, List<List<Integer>> ansList, List<Integer> currentList) {
        if (target == 0) {
            ansList.add(new ArrayList<>(currentList));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (target >= candidates[index]) {
            currentList.add(candidates[index]);
            combinationSumRec(index, candidates, target - candidates[index], ansList, currentList);
            currentList.remove(currentList.size() - 1);
        }
        combinationSumRec(index + 1, candidates, target, ansList, new ArrayList<>(currentList));
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        new CombinationSum1().combinationSum(array, 7);
    }
}
