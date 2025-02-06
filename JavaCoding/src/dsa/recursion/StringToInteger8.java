package dsa.recursion;

public class StringToInteger8 {

    public int myAtoi(String s) {
        return helper(s, 0, 1, 0, true, 0);
    }

    private int helper(String s, int index, int sign, long result, boolean leadingZero, int state) {
        if (index >= s.length()) {
            if (state == 2) {
                return clamp(sign * result);
            } else {
                return 0;
            }
        }

        char c = s.charAt(index);

        if (state == 0) { // Processing whitespace
            if (c == ' ') {
                return helper(s, index + 1, sign, result, leadingZero, state);
            } else {
                return helper(s, index, sign, result, leadingZero, 1); // Move to sign processing
            }
        } else if (state == 1) { // Processing sign
            if (c == '+') {
                return helper(s, index + 1, 1, 0, true, 2);
            } else if (c == '-') {
                return helper(s, index + 1, -1, 0, true, 2);
            } else {
                return helper(s, index, 1, 0, true, 2); // No sign, process digits
            }
        } else { // State 2: Processing digits
            if (leadingZero) {
                if (c == '0') {
                    return helper(s, index + 1, sign, 0, true, 2); // Skip leading zero
                } else if (Character.isDigit(c)) {
                    int digit = c - '0';
                    long newResult = digit;
                    // Check overflow for first non-zero digit
                    if (sign == 1 && newResult > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (sign == -1 && newResult > (long) Integer.MAX_VALUE + 1) {
                        return Integer.MIN_VALUE;
                    } else {
                        return helper(s, index + 1, sign, newResult, false, 2);
                    }
                } else {
                    return 0; // Non-digit encountered after leading zeros
                }
            } else {
                if (Character.isDigit(c)) {
                    int digit = c - '0';
                    long newResult = result * 10 + digit;
                    if (sign == 1) {
                        if (newResult > Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        if (newResult > (long) Integer.MAX_VALUE + 1) {
                            return Integer.MIN_VALUE;
                        }
                    }
                    return helper(s, index + 1, sign, newResult, false, 2);
                } else {
                    return clamp(sign * result); // Non-digit encountered, return current result
                }
            }
        }
    }

    private int clamp(long value) {
        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) value;
        }
    }

    public int myAtoiIterative(String s) {
        if (s != null && s.trim().isEmpty()) return 0;

        double num = 0.0;
        s = s.trim();
        boolean isNegative = false;
        char sign = s.charAt(0);
        if (sign == '-' || sign == '+') {
            if (sign == '-')
                isNegative = true;
            s = s.substring(1);
        }

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else {
                break;
            }
        }
        return (int) (isNegative ? -num : num);
    }


    public static void main(String[] args) {
        StringToInteger8 solution = new StringToInteger8();
        System.out.println(solution.myAtoi("42")); // 42
        System.out.println(solution.myAtoi("   -042")); // -42
        System.out.println(solution.myAtoi("words and 987")); // 0
        System.out.println(solution.myAtoi("-91283472332")); // -2147483648
        System.out.println(solution.myAtoi("2147483648")); // 2147483647
    }
}
