package Sort;

public class Radix {

	public static void Show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("************************************");
	}

	public static int GetMaxElement(int[] arr) {
		int nKey = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > nKey)
				nKey = arr[i];
		}
		return nKey;
	}

	public static void CountSort(int[] arr, int nExp) {
		int nLength = arr.length;
		int[] nTemp = new int[nLength];
		int[] nRadix = new int[nLength];
		for (int i = 0; i < nLength; i++) {
			nRadix[i] = 0;
		}

		for (int i = 0; i < nLength; i++) // 将各个位数上数据出现的次数存储在nRadix[]中
		{
			nRadix[(arr[i] / nExp) % 10]++;
		}

		for (int i = 1; i < 10; i++) // 总的索引
		{
			nRadix[i] += nRadix[i - 1];
		}

		for (int i = nLength - 1; i >= 0; i--) {
			nTemp[nRadix[(arr[i] / nExp) % 10] - 1] = arr[i];
			nRadix[(arr[i] / nExp) % 10]--;
		}

		for (int i = 0; i < nLength; i++) {
			arr[i] = nTemp[i];
		}
	}

	public static void RadixSort(int[] arr) {
		int nMax = GetMaxElement(arr);

		for (int nExp = 1; nMax / nExp > 0; nExp *= 10) {
			CountSort(arr, nExp); // Sort by Exp
			// Show(arr);
		}
	}

	public static void main(String[] args) {
		int[] arr_test = { 877, 477, 252, 22233, 5554, 155, 644, 932, 77, 27 };

		Show(arr_test);
		RadixSort(arr_test);
		Show(arr_test);
	}
}