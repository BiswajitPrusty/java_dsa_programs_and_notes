package recursion;

public class BinarySearchRec {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = bs(a, 0, a.length - 1, 8);
		System.out.println(" present at : " + index + " index");
	}

	public static int bs(int a[], int start, int end, int find) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;

		if (find == a[mid]) {
			return mid;
		}

		if (find < a[mid]) {
			return bs(a, start, mid - 1, find);

		}

		return bs(a, mid + 1, end, find);

	}

}
