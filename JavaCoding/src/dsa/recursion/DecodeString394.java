package dsa.recursion;

import java.util.Arrays;
import java.util.Stack;

public class DecodeString394 {
     volatile static int index = 0;
//    public static String decodeString2(String s) {
//        return decodeHelper(s);
//    }
    //3[ab]2[bc]
    private static String decodeHelper(String s) {
        StringBuilder result = new StringBuilder();

        while (index < s.length() && s.charAt(index) != ']') {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                int num = 0;
                // Extract full number (can be multi-digit like "23[a]")
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                // Skip '['
                index++;
                // Recursively decode inside brackets
                String decodedString = decodeHelper(s);
                // Skip ']'
                index++;
                // Append `num` times the decoded string
                while (num-- > 0) {
                    result.append(decodedString);
                }
            } else {
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(decodeHelper("3[a2[c]]"));
    }
    public static String decodeString(String input) {
        Stack<Character> s = new Stack<>();

        for(char c : input.toCharArray()){
            if(c != ']'){
                s.push(c);
            }else{
                StringBuilder str = new StringBuilder();
                while(s.peek() != '['){
                    str.append(s.pop());
                }
                s.pop();
                StringBuilder rep = new StringBuilder();
                while(!s.isEmpty() && Character.isDigit(s.peek())){
                    rep.append(Character.getNumericValue(s.pop()));
                }
                int repVal = Integer.valueOf(rep.reverse().toString());
                String reverse = str.reverse().toString();
                while(repVal > 1){
                    str.append(reverse);
                    repVal--;
                }
                for (char ch : str.toString().toCharArray()) {
                    s.push(ch);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }

        String result = sb.toString();
        System.out.println(result);
        return result;
    }
}
