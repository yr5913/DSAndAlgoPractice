package v2.myPractice;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!((chars[start] <= 'Z' && chars[start] >= 'A') || (chars[start] <= 'z' && chars[start] >= 'a'))) {
                start++;
            } else if (!((chars[end] <= 'Z' && chars[end] >= 'A') || (chars[end] <= 'z' && chars[end] >= 'a'))) {
                end--;
            } else {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        return String.valueOf(chars);
    }
}
