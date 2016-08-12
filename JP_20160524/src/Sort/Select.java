package Sort;

public class Select {

	public static void Show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("************************************");
	}

	// simple select
	public static void SwapElement(int[] arr, int a, int b) {
		int nTemp = arr[a];
		arr[a] = arr[b];
		arr[b] = nTemp;
	}

	public static int SelectMinKey(int[] arr, int i) {
		int nKey = i;
		for (int j = i + 1; j < arr.length; ++j) {
			if (arr[nKey] > arr[j])
				nKey = j;
		}
		return nKey;
	}

	public static void SelectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int nKey = SelectMinKey(arr, i);

			if (nKey != i)
				SwapElement(arr, i, nKey);
		}
	}

	//

	// Heap
	public static void AdjustHeap(int arr[], int nLength, int root) {
		int nTemp = arr[root];
		int nChild = 2 * root + 1;
		while (nChild < nLength) {
			if (nChild + 1 < nLength && arr[nChild] < arr[nChild + 1])
				nChild++;
			if (arr[root] < arr[nChild]) {
				arr[root] = arr[nChild];
				root = nChild;
				nChild = 2 * root + 1;
			} else
				break;

			arr[root] = nTemp;
		}
	}

	public static void HeapSort(int arr[]) {
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			AdjustHeap(arr, arr.length, i);
		}
		for (int i = arr.length - 1; i > 0; i--) {
			SwapElement(arr, 0, i);
			AdjustHeap(arr, i, 0);
		}
	}

	public static void main(String[] args) {
		int[] arr_test = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };
		Show(arr_test);
		SelectSort(arr_test);
		Show(arr_test);

		int[] arr_test1 = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };
		Show(arr_test1);
		HeapSort(arr_test1);
		Show(arr_test1);
	}
}