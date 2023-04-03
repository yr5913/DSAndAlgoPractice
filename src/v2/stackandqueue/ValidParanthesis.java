package v2.stackandqueue;

import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                characters.push(chars[i]);
            } else {
                if (characters.isEmpty()) {
                    return false;
                }
                if ((chars[i] == ')' && characters.peek() != '(')
                        || (chars[i] == '}' && characters.peek() != '{')
                        || (chars[i] == ']' && characters.peek() != '['))
                    return false;
                characters.pop();
            }
        }
        return characters.isEmpty();
    }
}
