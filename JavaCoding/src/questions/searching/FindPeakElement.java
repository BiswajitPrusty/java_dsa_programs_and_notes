package questions.searching;

public class FindPeakElement {

    public static void main(String[] args) {
        peakElement(new int[]{1,2,3,1});
    }
    public static int peakElement(int[] arr) {

        //corner cases when the last and first element is greater
        int len = arr.length - 1;
        if(arr.length == 1) return 0;
        if(arr[0] >= arr[1]) return 0;
        if(arr[len] >= arr[len - 1]) return len;

        for (int i = 1; i <= len - 1; i++) {
            //condition to get the peak number
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
