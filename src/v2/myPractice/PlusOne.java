package v2.myPractice;

import v2.util.Helpers;
import v2.util.PrintHelper;

import java.math.BigDecimal;
import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        BigDecimal bigDecimal = new BigDecimal(sb.toString());
        BigDecimal bigDecimal1 = bigDecimal.add(new BigDecimal("1"));
        String string = bigDecimal1.toString();
        int[] returnVal = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            returnVal[i] = Integer.parseInt(string.substring(i, i + 1));
        }
        return returnVal;
    }

    public static void main(String[] args) {
        int[] array = new int[90];
        for (int i = 0; i < array.length; i++) {
            array[i] = 9;
        }

        int [] ret = new PlusOne().plusOne(array);
        System.out.println(Arrays.toString(ret));
    }
}
