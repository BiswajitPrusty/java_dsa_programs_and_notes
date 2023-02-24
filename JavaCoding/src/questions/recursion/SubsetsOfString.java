package questions.recursion;

public class SubsetsOfString {

    public static void main(String[] args) {
        printSubset("ABC", "", 0);
    }

    public static void printSubset(String s, String current, int index) {
        if (s.length() == index) {
            System.out.print(current + ", ");
            return;
        }
        printSubset(s, current, index + 1);
        printSubset(s, current + s.charAt(index), index + 1);
    }
}
