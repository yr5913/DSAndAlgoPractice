package v2.Recursion2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ansList = new ArrayList<>();
        wordBreakRec(s, wordDict.stream().collect(Collectors.toSet()), ansList, "", 0);
        return ansList;
    }

    public void wordBreakRec(String s, Set<String> wordDict, List<String> ansList, String current, int start) {
        if (start == s.length()) {
            ansList.add(current.substring(0, current.length() - 1));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isDictPresent(wordDict, sub)) {
                wordBreakRec(s, wordDict, ansList, current + sub + " ", i);
            }
        }
    }

    public boolean isDictPresent(Set<String> wordDict, String s) {
        return wordDict.contains(s);
    }
}
