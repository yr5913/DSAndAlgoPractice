package v2.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> ansList = new ArrayList<>();
        partitionRec(0, 0, s, new ArrayList<>(), ansList);
        return ansList;
    }

    public void partitionRecOne(int index, int len, String s, List<String> currentList, List<List<String>> ansList) {
        if (index == len) {
            if (s.length() == 0) {
                ansList.add(new ArrayList<>(currentList));
            }
            return;
        }
        int i = index - len + s.length() + 1;
        String temp = s.substring(0, i);
        if (isPalindrome(temp)) {
            currentList.add(temp);
            partitionRec(index + 1, len, s.substring(i), currentList, ansList);
            currentList.remove(currentList.size() - 1);
        }
        partitionRec(index + 1, len, s, currentList, ansList);
    }

    public void partitionRec(int index, int start, String s, List<String> currentList, List<List<String>> ansList) {
        if (index == s.length()) {
            if (index == start) {
                ansList.add(new ArrayList<>(currentList));
            }
            return;
        }
        if (isPalindrome(s, start, index)) {
            currentList.add(s.substring(start, index + 1));
            start = index + 1;
            partitionRec(index + 1, index + 1, s, currentList, ansList);
            currentList.remove(currentList.size() - 1);
        }
        partitionRec(index + 1, start, s, currentList, ansList);
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
