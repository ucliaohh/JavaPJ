package Sort;

public class Swap {

	public static void Show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("************************************");
	}

	public static void SwapElement(int[] arr, int a, int b) {
		int nTemp = arr[a];
		arr[a] = arr[b];
		arr[b] = nTemp;
	}

	// Bubble
	public static void Bubble(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					SwapElement(arr, j, j + 1);
				}
			}
		}
	}

	// Quick
	public static int Divide(int[] arr, int nLow, int nHigh) {
		int nPrivotKey = arr[nLow];
		while (nLow < nHigh) {
			// 从后往前在后半部分中寻找第一个小于枢纽元素的元素
			while (nLow < nHigh && arr[nHigh] >= nPrivotKey) {
				nHigh--;
			}
			SwapElement(arr, nLow, nHigh); // 将这个比枢纽元素小的元素交换到前半部分

			// 从前往后在前半部分中寻找第一个大于枢纽元素的元素
			while (nLow < nHigh && arr[nLow] <= nPrivotKey) {
				nLow++;
			}
			SwapElement(arr, nLow, nHigh); // 将这个比枢纽元素大的元素交换到后半部分
		}

		return nLow; // 返回枢纽元素所在的位置
	}

	public static void Quick(int[] arr, int nLow, int nHigh) {
		if (nLow < nHigh) {
			int nPrivotKey = Divide(arr, nLow, nHigh);
			Quick(arr, nLow, nPrivotKey - 1);
			Quick(arr, nPrivotKey + 1, nHigh);
		}
	}

	public static void main(String[] args) {
		int[] arr_test = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };
		Show(arr_test);
		Bubble(arr_test);
		Show(arr_test);

		int[] arr_test1 = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };
		Show(arr_test1);
		Quick(arr_test1, 0, arr_test1.length - 1);
		Show(arr_test1);
	}
}