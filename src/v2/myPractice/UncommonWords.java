package v2.myPractice;

import java.util.*;
import java.util.stream.Collectors;

public class UncommonWords {

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] stringOneSplit = s1.split(" ");
        Map<String, Integer> stringOneMap = new HashMap<>();
        Arrays.stream(stringOneSplit).forEach(s -> {
            stringOneMap.put(s, stringOneMap.getOrDefault(s, 0) + 1);
        });

        String[] stringTwoSplit = s2.split(" ");
        Map<String, Integer> stringTwoMap = new HashMap<>();
        Arrays.stream(stringTwoSplit).forEach(s -> {
            stringTwoMap.put(s, stringTwoMap.getOrDefault(s, 0) + 1);
        });
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : stringOneMap.keySet()) {
            if (stringOneMap.get(s) == 1 && !stringTwoMap.containsKey(s)) {
                arrayList.add(s);
            }
        }
        for (String s : stringTwoMap.keySet()) {
            if (stringTwoMap.get(s) == 1 && !stringOneMap.containsKey(s)) {
                arrayList.add(s);
            }
        }
        String[] ret = new String[arrayList.size()];
        arrayList.toArray(ret);
        return ret;
    }
}
