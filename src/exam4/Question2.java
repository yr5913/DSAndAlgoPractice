package exam4;

import java.util.*;

public class Question2 {

    public static void main(String[] args) {
        String[] x = {"yy", "u", "oe"};
        String[] y = {"1-2", "2-3"};
        hasVowels(new ArrayList<>(Arrays.asList(x)), new ArrayList<>(Arrays.asList(y)));
    }

    public static List<Integer> hasVowels(List<String> strArr, List<String> query) {
        int[] sum = new int[strArr.size() + 1];
        List<Integer> list = new ArrayList<>(query.size());
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < strArr.size(); i++) {
            String string = strArr.get(i);
            boolean match = true;
            if (!vowels.contains(string.charAt(0))) {
                match = false;
            }
            if (string.length() > 1) {
                if (!vowels.contains(string.charAt(string.length() - 1))) {
                    match = false;
                }
            }
            if (match)
                sum[i + 1] = sum[i] + 1;
            else
                sum[i + 1] = sum[i];
        }
        for (String singleQuery : query) {
            String[] splitString = singleQuery.split("-");
            int start = Integer.parseInt(splitString[0]);
            int end = Integer.parseInt(splitString[1]);
            int value = 0;
            if (start == end) {
                if (sum[start - 1] != sum[start])
                    value = 1;
            } else
                value = sum[end] - sum[start - 1];
            list.add(value);
        }
        return list;
    }
}
