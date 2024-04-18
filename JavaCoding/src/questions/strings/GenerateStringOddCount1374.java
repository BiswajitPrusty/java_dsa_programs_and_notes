package questions.strings;

public class GenerateStringOddCount1374 {

    public static void main(String[] args) {
        System.out.println(generateTheString(7));
    }

    public static String generateTheString(int n) {
        StringBuilder s = new StringBuilder();
        if(n % 2 == 0)
            s.append("t".repeat(n - 11));
        else
            s.append("t".repeat(n));
        return s.toString();
    }
}
