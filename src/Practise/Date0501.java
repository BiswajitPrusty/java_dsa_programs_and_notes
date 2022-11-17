package Practise;

import java.util.Random;

public class Date0501 {

    public static void main(String[] args) {
        String world = " aaabbbccc ";
        stringDuplicates(world);
    }

    public static void stringDuplicates(String input) {
        char a[] = input.toCharArray();
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            char c = a[i];
            for (int j = i; j < a.length; j++) {
                if (c == ' ') {
                    break;
                } else if (c == a[j]) {
                    count++;
                    a[j] = ' ';
                }
            }
            if(c !=' ')
            System.out.print(c+" = "+ count+", ");
        }

    }
}
