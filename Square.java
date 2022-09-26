package math;

import java.math.BigDecimal;

public class Square {
    public static double SquareInt(int n, int precision) {
        if (n <= 1) {
            return n;
        }

        double i = 1;
        while (i <= Math.sqrt(Integer.MAX_VALUE) && i * i < n) {
            i = i * 2;
        }

        double a1 = 0;
        double a2 = 0;
        if (i > Math.sqrt(Integer.MAX_VALUE)) {
            a1 = i / 2;
            a2 = Math.sqrt(Integer.MAX_VALUE);
        } else { // i * i >= n
            a1 = i / 2 ;
            a2 = i;
        }

        double gap = 0.1;
        for (int j = 1; j <= precision; j++) {
            gap /= 10;
        }

        double mid = 0;
        while (a1 < a2) {
            if (a2 - a1 <= gap) {
                if (a2 * a2 <= n) {
                    return a2;
                } else {
                    return a1;
                }
            }

            mid = (a1 + a2) / 2;

            double s2 = mid * mid;
            if (s2 == n) {
                return mid;
            } else if (s2 < n) {
                a1 = mid;
            } else { //
                a2 = mid;
            }
        }

        return -1;
    }

    public static double processPrecision(double value, int precision) {
        BigDecimal b = new BigDecimal(value);
        return b.setScale(precision, BigDecimal.ROUND_DOWN).doubleValue();
    }


    public static void test1() {
        int value = 3;
        int precision = 2;
        double a = SquareInt(value, precision);
        double a1 = processPrecision(a, precision);
        System.out.println(a + " => " + a1);
    }

    public static void test2() {
        int value = 9;
        int precision = 2;
        double a = SquareInt(value, precision);
        double a1 = processPrecision(a, precision);
        System.out.println(a + " => " + a1);

    }

    public static void test3() {
        int value = 2;
        int precision = 3;
        double a = SquareInt(value, precision);
        double a1 = processPrecision(a, precision);
        System.out.println(a + " => " + a1);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }
}
