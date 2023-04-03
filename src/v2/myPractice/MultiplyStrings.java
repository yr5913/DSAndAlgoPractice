package v2.myPractice;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0")) {
            return num2;
        }
        if (num2.equals("0")) {
            return num1;
        }
        char[] array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        String result = "0";
        for (int i = array.length - 1; i >= 0; i--) {
            StringBuilder inner = new StringBuilder();
            int carry = 0;
            int x = array[i] - '0';
            if (x == 0)
                continue;
            for (int j = num2Array.length - 1; j >= 0; j--) {
                int y = num2Array[j] - '0';
                int val = x * y + carry;
                carry = val / 10;
                inner.append(val % 10);
            }
            if (carry != 0) {
                inner.append(carry);
            }
            if (inner.toString().equals("0")) {
                continue;
            }
            inner = inner.reverse();
            for (int k = i; k < array.length - 1; k++) {
                inner.append(0);
            }
            result = add(inner.toString(), result);
        }
        return result;
    }

    public String add(String num1, String num2) {
        if (num2.equals("0")) {
            return num1;
        }
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        char[] smallArray = num1Array;
        char[] largeArray = num2Array;
        StringBuilder stringBuilder = new StringBuilder();
        if (num2Array.length < num1Array.length) {
            largeArray = num1Array;
            smallArray = num2Array;
        }
        int carry = 0;
        for (int i = 0; i < smallArray.length; i++) {
            int x = smallArray[smallArray.length - i - 1] - '0';
            int y = largeArray[largeArray.length - i - 1] - '0';
            int val = x + y + carry;
            stringBuilder.append(val % 10);
            carry = val / 10;
        }
        for (int i = smallArray.length; i < largeArray.length; i++) {
            int x = largeArray[largeArray.length - i - 1] - '0';
            int val = x + carry;
            stringBuilder.append(val % 10);
            carry = val / 10;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String val = new MultiplyStrings().multiply("9133", "0");
        System.out.println(val);
        System.out.println(123 * 78);
    }
}
