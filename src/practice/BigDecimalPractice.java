package practice;

import java.math.BigDecimal;

public class BigDecimalPractice {

    public static void main(String[] args) {
        int x = 20;

        BigDecimal bigDecimal = new BigDecimal(String.valueOf(10));
        BigDecimal bigDecimal1 = new BigDecimal("4646565656565656565656565656655656548822222222222222222.888888888888888888");
        System.out.println(bigDecimal.add(bigDecimal1));
        int ui = bigDecimal.multiply(bigDecimal1).intValue();
        System.out.println(ui);
        System.out.println(bigDecimal.add(new BigDecimal("20")).multiply(new BigDecimal("30")).add(new BigDecimal("20")));
        int y = 2+3;
    }
}
