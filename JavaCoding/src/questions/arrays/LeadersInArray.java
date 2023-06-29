package questions.arrays;

public class LeadersInArray {

    public static void main(String[] args) {
        findLeadersEfficient(new int[]{16, 17, 4, 3, 5, 2});
    }

    public static void findLeadersEfficient(int[] arr) {
        int largest = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > largest) {
                largest = arr[i];
                System.out.println(largest);
            }

        }
    }
    public static void printLeaders(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                boolean leader = true;
                for (int j = i; j < arr.length; j++) {
                    if (arr[i] < arr[j]) {
                        leader = false;
                        break;
                    }
                }
                if(leader) System.out.println(arr[i]);
            }
        }
        System.out.println(arr[arr.length - 1]);
    }
}
