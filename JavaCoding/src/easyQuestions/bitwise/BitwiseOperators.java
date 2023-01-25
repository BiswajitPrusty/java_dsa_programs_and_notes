package easyQuestions.bitwise;


public class BitwiseOperators {
    public static void main(String[] args) {
        andOperator();
        orOperator();
        xorOperator();
        bitwiseNOtOperator();
        leftShiftOperator();
        rightShiftOperator();
    }

    public static void andOperator() {
        //3 =   0000...11
        //6 =   0000..110
        //3&6 = 0000..010 (2)
        int x = 3, y = 6;
        System.out.println(x & y);
    }

    public static void orOperator() {
        //3 =   0000..011
        //6 =   0000..110
        //3&6 = 0000..111 (7)
        int x = 3, y = 6;
        System.out.println(x | y);
    }

    public static void xorOperator() {
        //3 =   0000..011
        //6 =   0000..110
        //3&6 = 0000..101 (5)
        int x = 3, y = 6;
        System.out.println(x ^ y);
    }

    public static void bitwiseNOtOperator() {
        //1 =   0000..001
        int x = 6;
        System.out.println(~x);
    }

    public static void leftShiftOperator() {
        //6 =   0000..110
        //6 =   0000.1100    (x << 1)
        //6 =   000.11000    (x << 2)
        int x = 6;
        System.out.println(x << 1);
        System.out.println(x << 2);
    }

    public static void rightShiftOperator() {
        //6 =   0000..110
        //6 =   0000.0011    (x >> 1)
        //6 =   000..0001    (x >> 2)
        int x = 6;
        System.out.println(x >> 1);
        System.out.println(x >> 2);
    }


}
