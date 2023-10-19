package questions.strings;

public class FaultyKeyboard2810 {
    public String finalString(String s) {
        char letters[] = s.toCharArray();
        int start = 0, end = 0, len = s.length();
        while(end < len){
            if(letters[end] == 'i'){
                reverse(start, end - 1, letters);
                start = end + 1;
            }
            end++;
        }
        String response =  new String(letters);
        response = response.replace("i", "");
        return response;
    }

    public void reverse(int start, int end, char[] letters){
        while(start <= end){
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
    }
}
