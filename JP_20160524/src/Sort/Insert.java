package Sort;

public class Insert {

	public static void Show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("************************************");
	}

	public static void InsertSort(int[] arr, int nDelt) {
		for (int i = nDelt; i < arr.length; i++) {
			if (arr[i] < arr[i - nDelt]) {
				int nTemp = arr[i];
				arr[i] = arr[i - nDelt];
				int j = i - nDelt;
				while (nTemp < arr[j]) {
					arr[j + nDelt] = arr[j];
					j -= nDelt;
					if (j < 0)
						break;
				}
				arr[j + nDelt] = nTemp;
			}
		}
	}

	public static void ShellSort(int arr[]) {
		int nDelt = arr.length / 2;
		while (nDelt >= 1) {
			InsertSort(arr, nDelt);
			nDelt /= 2;
		}
	}

	public static void main(String[] args) {
		int[] arr_test = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };
		int[] arr_test1 = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };

		Show(arr_test);
		InsertSort(arr_test, 1);
		Show(arr_test);

		Show(arr_test1);
		ShellSort(arr_test1);
		Show(arr_test1);
	}
}