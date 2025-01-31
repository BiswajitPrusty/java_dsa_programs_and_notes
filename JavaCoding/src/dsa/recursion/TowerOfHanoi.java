package dsa.recursion;

public class TowerOfHanoi {


    static int count = 0;
    public static int solve(String source, String destination, String helper, int disks) {
        count++;
        if (disks == 1) {
            System.out.println("Moving disk: " + disks + " from " + source + " to " + destination);
            return count;
        }
        solve(source, helper, destination, disks - 1);
        System.out.println("Moving disk: " + disks + " from " + source + " to " + destination);
        solve(helper, destination, source, disks - 1);
        return count;
    }

    public static void main(String[] args) {
        int solve = solve("A", "C", "B", 2);
        System.out.println(solve);
    }
}
