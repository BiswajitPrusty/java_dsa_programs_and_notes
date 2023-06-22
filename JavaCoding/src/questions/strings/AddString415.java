package questions.strings;

public class AddString415 {

    /*
    Input: num1 = "0", num2 = "0"
    Output: "0"

    Input: num1 = "11", num2 = "123"
    Output: "134"
     */

    public static void main(String[] args) {
        System.out.println(addStrings("0", "0"));
    }

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = num1.length() - 1,j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {

        }
        return ans.reverse().toString();
    }

}
