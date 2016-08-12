package Sort;

public class Merge {

	public static void Show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("************************************");
	}

	public static void MergeArray(int[] arr, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[start + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = arr[mid + i + 1];
		}

		L[n1] = 100000;
		R[n2] = 100000;
		for (int i = 0, j = 0, k = start; k <= end; k++) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
		}
	}

	private static void MergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (end + start) / 2;
			MergeSort(arr, start, mid);
			MergeSort(arr, mid + 1, end);
			MergeArray(arr, start, mid, end);
		}
	}

	public static void main(String[] args) {
		int[] arr_test = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };
		Show(arr_test);
		MergeSort(arr_test, 0, arr_test.length - 1);
		Show(arr_test);
	}
}