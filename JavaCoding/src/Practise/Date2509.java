package Practise;

import java.util.*;
import java.util.stream.Collectors;

public class Date2509 {

    public static void main(String[] args) {

//        miniMaxSum(Arrays.asList(7, 69, 2, 221, 8974));
        System.out.println(timeConversion("12:45:54PM")
        );
    }

    public static String timeConversion(String s) {
        // Write your code here
        String t = s.charAt(0) + "" + s.charAt(1);
        String ap = s.charAt(s.length() - 2) + "";
        int time = Integer.parseInt(t);

        if (ap.equalsIgnoreCase("a") && time < 10)
            return 0 + "" + time + "" + s.substring(2, s.length() - 2);
        else if(ap.equalsIgnoreCase("a") && time ==12)
            return 0+""+0 + "" + s.substring(2, s.length() - 2);
        else if(ap.equalsIgnoreCase("a"))
            return time + "" + s.substring(2, s.length() - 2);


        if (ap.equalsIgnoreCase("p") && time == 12)
            return 12 + "" + s.substring(2, s.length() - 2);
        else if (ap.equalsIgnoreCase("p"))
            return 12 + time + "" + s.substring(2, s.length() - 2);

        System.out.println(time);
        return "";
    }


    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            long temp = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (i != j) {
                    temp = temp + arr.get(j);
                }
            }
            a.add(temp);
        }
        List<Long> list = a.stream().sorted().collect(Collectors.toList());
        System.out.println(arr);
        System.out.println(list);
        System.out.println(list.get(0) + " " + list.get(a.size() - 1));

    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        ArrayList<Integer> a = new ArrayList<>(arr);

        int plus = 0, minu = 0, zero = 0;
        for (Integer i : a) {
            if (i > 0)
                plus++;
            else if (i < 0)
                minu++;
            else
                zero++;
        }

        double pos = (double) plus / a.size();
        double neg = (double) minu / a.size();
        double ze = (double) zero / a.size();
        System.out.printf(" %.6f", pos);
        System.out.println();
        System.out.printf(" %.6f", neg);
        System.out.println();
        System.out.printf(" %.6f", ze);

    }
}
