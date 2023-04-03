package v2.array4;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> characters = new HashMap<>();
        int maxLength = 0;
        int length = 0;
        int lastRemoveIndex = 0;
        for (int i = 0; i < array.length; i++) {
            char singleChar = array[i];
            if (characters.containsKey(singleChar)) {
                int index = characters.get(singleChar);
                for (int j = lastRemoveIndex; j < index; j++) {
                    characters.remove(array[j]);
                }
                lastRemoveIndex = index + 1;
                maxLength = Math.max(length, maxLength);
                length = i - index;
                characters.put(singleChar, i);
            } else {
                characters.put(singleChar, i);
                length++;
            }
        }
        return Math.max(maxLength, length);
    }

    public static void main(String[] args) {
        new LongestSubstring().lengthOfLongestSubstring("abcabcbb");
    }
}
