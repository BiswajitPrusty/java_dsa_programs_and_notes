package questions.arrays;

public class RemoveTrailingZeros2710 {

    public static void main(String[] args) {
        System.out.println(removeTrailingZeros("123"));
    }
    public static String removeTrailingZeros(String num) {
        int subStringLength = num.length();
        for(int i = num.length() - 1; i >= 0; i-- ){
            if(num.charAt(i) == '0'){
                subStringLength = i;
            }else{
                break;
            }
        }
        return num.substring(0, subStringLength);
    }

}
