package questions.searching;

public class ConvertBinaryNumberLinkedListInteger1290 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(getDecimalValue(list));
    }

    public static int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans << 1;
            if (head.val == 1) {
                ans = ans | 1;
            }
            head = head.next;
        }
        return ans;
    }
}
