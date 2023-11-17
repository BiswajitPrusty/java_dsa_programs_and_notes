package questions.strings;

public class CountAsterisks2315 {
    public static void main(String[] args) {
        System.out.println(countAsterisks("|**|*|*|**||***||"));
    }

    public static int countAsterisks(String s) {

        int countOfStarts = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if ('*' == s.charAt(i)) {
                count++;
                i++;
                while (i < s.length()) {
                    if ('*' == s.charAt(i))
                        count++;
                    else
                        break;
                    i++;
                }
            }
            if (count >= 2) {
                countOfStarts += count;
            }
        }
        return countOfStarts;
    }

    public int count(String s) {
        int c = 0, count = 0;
        char ch[] = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
            if (ch[i] == '|')
                count++;
            if ((ch[i] == 42 || ch[i] == '*') && (count % 2 == 0))
                c++;
        }
        return c;
    }
}
