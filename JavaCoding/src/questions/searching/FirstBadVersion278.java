package questions.searching;

public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean checkVersion = isBadVersion(mid);
            if (checkVersion) {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (checkVersion) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public boolean isBadVersion(int n) {
        return false;
    }
}
