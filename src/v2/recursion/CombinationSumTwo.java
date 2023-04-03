package v2.recursion;

import java.util.*;

public class CombinationSumTwo {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumRec(0, candidates, target, ansList, new ArrayList<>());
        return ansList;
    }

    public void combinationSumRec(int index, int[] candidates, int target, List<List<Integer>> ansList, List<Integer> currentList) {
        if (target == 0) {
            ansList.add(new ArrayList<>(currentList));
        }
        for (int i = index; i < candidates.length; i++) {
            if ((i != index && candidates[i] == candidates[i - 1])) {
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            currentList.add(candidates[i]);
            combinationSumRec(i + 1, candidates, target - candidates[i], ansList, currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
