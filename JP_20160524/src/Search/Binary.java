package Search;

public class Binary {

	public static void Show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("************************************");
	}

	public static int BinarySearch(int[] arr, int nLength, int nTarget) {
		int low = 0, high = nLength, middle = 0;
		while (low < high) {
			middle = (low + high) / 2;
			if (nTarget == arr[middle]) {
				return middle;
			} else if (nTarget < arr[middle]) {
				high = middle;
			} else if (nTarget > arr[middle]) {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr_test = { 4, 25, 133, 998, 3555, 7897, 8988, 9011, 9565, 10023 };
		Show(arr_test);
		int nIndex = BinarySearch(arr_test, arr_test.length, 9011);
		System.out.print("BinarySearch : " + nIndex + "\r\n");

		// call "class BinaryTree" , but it can't call "class TreeNode" of
		// "class BinaryTree"
		BinaryTree bTree = new BinaryTree();
		bTree.BuildTree(arr_test); // static function call no-static function
		bTree.TravelTree(bTree.GetRoot());
		System.out.print("\r\n"
				+ bTree.SearchTree(bTree.GetRoot(), 9011).GetNodeValue());
	}
}