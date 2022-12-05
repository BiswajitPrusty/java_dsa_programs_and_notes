package recursion;

public class AddingNnums {

    public static int add(int n) {
        if (n == 1)
            return n;
        return n + add(n - 1);
    }

    public static void main(String[] args) {
        int res = add(5);
        System.out.println(res);
    }
}
