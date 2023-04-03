package v2.recursion;

import v2.util.PrintHelper;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int counter = 1;
        int[] integers = new int[n];
        for (int i = 0; i < n; i++) {
            integers[i] = i + 1;
        }
        int val = 1;
        while (k >= val) {
            val *= ++counter;
        }
        val = val / counter;
        while (k > 0) {
            if (k == val) {
                reverse(integers, integers.length - counter + 1, integers.length - 1);
                break;
            }
            int times = k / val;
            int index = integers.length - counter + times;
            shift(integers, integers.length - counter, index);
            k = k % val;
            counter--;
        }
        PrintHelper.printArray(integers);
        return "";
    }

    public void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void main(String[] args) {
        new PermutationSequence().getPermutation(4, 3);
    }

    public void shift(int[] array, int start, int end) {
        int temp = array[end];
        for (int i = end - 1; i >= start; i--) {
            array[i + 1] = array[i];
        }
        array[start] = temp;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public String getPermutation(int k, String s, int val, int counter, int start, int end) {
        if (k == 0) {
            return s;
        }
        int currentVal = val * counter;
        if (k > currentVal)
            return getPermutation(k, s, currentVal, counter + 1, start - 1, end);
        if (k < currentVal) {
            return reverseString(s, 0, s.length());
        } else {
            return getPermutation(k - val, s, currentVal, counter + 1, start - 1, end);
        }

    }

    public String reverseString(String s, int start, int end) {
        char[] chars = s.toCharArray();
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        return String.valueOf(chars);
    }
}
