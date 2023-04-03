package v2.myPractice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursiveParenthesis(n, n, new char[n * 2], 0, list);
        return list;
    }

    public void recursiveParenthesis(int n1, int n2, char[] characters, int n, List<String> list) {
        if (n1 == 0 && n2 == 0) {
            list.add(String.valueOf(characters));
            return;
        }
        if (n2 > n1) {
            characters[n] = ')';
            recursiveParenthesis(n1, n2 - 1, characters, n + 1, list);
            if (n1 != 0) {
                characters[n] = '(';
                recursiveParenthesis(n1 - 1, n2, characters, n + 1, list);
            }
        } else {
            characters[n] = '(';
            recursiveParenthesis(n1 - 1, n2, characters, n + 1, list);
        }
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
