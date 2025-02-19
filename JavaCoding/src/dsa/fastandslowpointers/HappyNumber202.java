package dsa.fastandslowpointers;

public class HappyNumber202 {

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow > 1);
        return slow == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber202 h = new HappyNumber202();
        System.out.println(h.isHappy(19));
    }
}
