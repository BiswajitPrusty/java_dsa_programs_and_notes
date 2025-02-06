package dsa.recursion;

public class Subsets {

    public static void main(String[] args) {
        solve("AAB", "");
    }

    public static void solve(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        String output1 = output;
        String output2 = output;

        output2 += input.charAt(0);
        input = input.substring(1);

        solve(input, output1);
        solve(input, output2);
    }
}
