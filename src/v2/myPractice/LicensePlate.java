package v2.myPractice;

import java.util.HashSet;
import java.util.Set;

public class LicensePlate {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Set<Character> charSet = new HashSet<>();
        int[] count = charsToBeChecked(licensePlate, charSet);
        int len = Integer.MAX_VALUE;
        int index = 0;
        int counter = 0;
        for (String word : words) {
            int[] currentCount = new int[26];
            for (char character : word.toCharArray()) {
                currentCount[character - 'a']++;
            }
            boolean isValid = true;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > currentCount[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (len > word.length()) {
                    len = word.length();
                    index = counter;
                }
            }
            counter++;
        }
        return words[index];

    }

    public int[] charsToBeChecked(String licensePlate, Set<Character> characters) {
        int[] chars = new int[26];
        char[] licensePlateCharArray = licensePlate.toLowerCase().toCharArray();
        for (int i = 0; i < licensePlateCharArray.length; i++) {
            if (licensePlateCharArray[i] >= 'a' && licensePlateCharArray[i] <= 'z') {
                characters.add(licensePlateCharArray[i]);
                chars[licensePlateCharArray[i] - 'a']++;
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        String[] words = {"step", "steps", "stripe", "stepple"};
        new LicensePlate().shortestCompletingWord("1s3 PSt", words);
    }
}
