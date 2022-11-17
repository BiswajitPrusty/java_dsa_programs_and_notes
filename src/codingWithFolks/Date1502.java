package codingWithFolks;

public class Date1502 {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        for (int i :a)
            System.out.print(i+" ");
        abc(a);

        System.out.println();
        for (int i :a)
            System.out.print(i+" ");

    }

    public int removeElement(int[] nums, int val) {

        int count = 0;

        for (int i = 0; i < nums.length -1; i++) {
            if (val == nums[i]) {
                nums[i] =0;
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums.length - count;
    }

    static public int abc(int a[]) {
        a[0] =0;
        return a.length;
    }

    public int lengthOfLastWord(String s) {


        String[] a = s.split(" ");
        return a[a.length - 1].length();

    }

    public int second(String s) {

        if(s.length()  == 1)
            return 1;

        int ans = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) != ' ') {

                if (s.charAt(i) != ' ') {
                    for (int j = i; j > 0; j--) {
                        if (s.charAt(j) != ' ')
                            ans++;
                        else
                            return ans;
                    }
                }
            }
        }
        return ans;

    }

}
