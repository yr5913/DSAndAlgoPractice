package v2.myPractice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        char[] start = {'a', 'd','g','j', 'm', 'p', 't', 'w'};
        List<String> stringList = new ArrayList<>();
        letterCombinationsRec(digits.toCharArray(), 0, "", stringList, start);
        return stringList;

    }

    public void letterCombinationsRec(char[] digits, int current, String currentString, List<String> stringList, char[] start) {
        if (digits.length == current) {
            if (currentString.length() != 0)
                stringList.add(currentString);
            return;
        }
        int index = digits[current] - '2';
        char end = 'z' + 1;
        if (index != start.length - 1) {
            end = start[index + 1];
        }
        for (char i = start[index]; i < end; i++) {
            letterCombinationsRec(digits, current + 1, currentString + i, stringList, start);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
    }
}
