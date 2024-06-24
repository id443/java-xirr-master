package org.decampo.xirr;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        double rate = new Xirr(
                new Transaction(-4548, "2022-04-01"),
                new Transaction(1762.90, "2022-04-02"),
                new Transaction(13381.45, "2022-05-02"),
                new Transaction( 440.73, "2022-06-02"),
                new Transaction( 220.37, "2022-07-02"),
                new Transaction( 110.18, "2022-08-02"),
                new Transaction( 55.00, "2022-09-02")
        ).xirr();
        double rate2 = new Xirr(
                new Transaction(-4548, "2022-04-01"),
                new Transaction(1762.90, "2022-04-02"),
                new Transaction(880.45, "2022-05-02"),
                new Transaction( 440.73, "2022-06-02"),
                new Transaction( 220.37, "2022-07-02"),
                new Transaction( 110.18, "2022-08-02"),
                new Transaction( 55.00, "2022-09-02")
        ).xirr();

        System.out.println(new BigDecimal(rate).toPlainString());
    }
}
