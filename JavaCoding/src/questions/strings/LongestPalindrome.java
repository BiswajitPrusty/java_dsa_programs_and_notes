package questions.strings;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cccca"));
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        int ans = 0;
        for(char c : s.toCharArray()){
            count[c]++;
        }
        for(int v : count){
            ans += v/2 * 2;
            if(ans % 2 == 0 && v % 2 == 1){
                ans++;
            }
        }
        return ans;
    }
}
