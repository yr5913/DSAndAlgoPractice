package v2.myPractice;

import java.util.List;

public class Word1 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRec(s, wordDict, "");
    }

    public boolean wordBreakRec(String s, List<String> wordDict, String current) {
        if (current.length() > s.length()) {
            return false;
        } else if (current.equals(s)) {
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (wordBreakRec(s, wordDict, current + wordDict.get(i))) return true;
        }
        return false;
    }
}
