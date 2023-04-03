package v2.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combineRec(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    public void combineRec(int n, int k, int value, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k || value > n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = value; i <= n; i++) {
            if (list.size() + (n - i + 1) >= k) {
                list.add(i);
                combineRec(n, k, i + 1, list, ans);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
