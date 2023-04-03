package v2.myPractice;

import v2.stackandqueue.Stack;

public class Path {
    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        char[] ans = new char[chars.length];
        Stack stack = new Stack(chars.length);
        int index = 0;
        Integer startIndex = 1;
        ans[index++] = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current == '/') {
                if (ans[index - 1] != '/') {
                    stack.push(index - startIndex);
                    ans[index++] = '/';
                    startIndex = index;
                }
                continue;
            }
            if (current == '.') {
                if (ans[index - 1] == '/') {
                    if (i == chars.length - 1 || chars[i + 1] == '/')
                        continue;
                    if (chars[i + 1] == '.') {
                        if (i + 1 == chars.length - 1 || chars[i + 2] == '/') {
                            if (stack.isEmpty() == 0) {
                                index = index - stack.pop() - 1;
                                startIndex = index;
                            }
                            i++;
                            continue;
                        }
                    }

                }

            }
            ans[index++] = current;
        }
        if (index != 1 && ans[index - 1] == '/') {
            index--;
        }
        return String.valueOf(ans, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(new Path().simplifyPath("/a/../../b/../c//.//"));
    }
}
