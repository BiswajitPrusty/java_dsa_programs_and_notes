package questions.strings;

public class FrequenciesOfChar {

    public static void main(String[] args) {
        frequenciesOfCharacter("geeksforgeeks");
    }
    public static void frequenciesOfCharacter(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                char current = (char) ((char) 'a' + i);
                System.out.print(current + " = " + arr[i]+", ");
            }
        }
    }
}
