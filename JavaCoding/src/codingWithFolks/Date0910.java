package codingWithFolks;

public class Date0910 {

    //test cases passes
    public String longestCommonPrefix(String[] strs) {

        String result = "";


        String compare = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int count = 0;
            for (int j = 0; j < strs.length; j++) {
                if (compare.charAt(i) == strs[j].charAt(i)) {
                    count++;
                    if (count == strs.length) {
                        result = result + compare.charAt(i);
                        count = 0;
                    }
                }

            }
        }
        return result;
    }

    public String edgeCase(String[] strs) {

        String result = "";
        String compare = strs[0];
        for (int i = 0; i < compare.length(); i++) {
            int count = 0;
            for (int j = 0; j < strs.length; j++) {
                //abcde     abc
                if(i < strs[j].length()) {

                    if (compare.charAt(i) == strs[j].charAt(i)) {
                        count++;

                        if (count == strs.length) {
                            result = result + compare.charAt(i);
                            count = 0;
                        }

                    }else
                        return result;
                }

            }
        }
        return result;
    }
}
