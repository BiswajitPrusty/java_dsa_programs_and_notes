package questions.arrays;

public class FirstPalindromic2108 {

    public static void main(String[] args) {
        FirstPalindromic2108 s = new FirstPalindromic2108();
        System.out.println(s.isPalindrome(121));
    }
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalindrome(word))
                return word;
        }
        return "";
    }
    public boolean isPalindrome(int x) {
        StringBuilder string = new StringBuilder(x+"");
        return string.reverse().toString().equalsIgnoreCase(""+x);
    }

    public boolean isPalindrome(String s){
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
