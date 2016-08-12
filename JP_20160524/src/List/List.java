package List;

public class List { // If it was "private\protected", it is wrong. We may change
					// its members to "private\protected".

	private final int ListSize = 10; // = #define of C++

	private class ListNode {
		protected int data;
		@SuppressWarnings("unused")
		protected ListNode next;

		private ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private ListNode[] pLt = new ListNode[ListSize];

	private void Insert(int[] Array) {
		pLt[0] = new ListNode(Array[0]);
		for (int i = 1; i < ListSize; i++) {
			pLt[i] = new ListNode(Array[i]);
			pLt[i - 1].next = pLt[i];
		}
	}

	public static void main(String[] args) {
		int[] arr_test = { 4, 25, 133, 998, 3555, 7897, 8988, 9011, 9565, 10023 };
		List bList = new List();
		bList.Insert(arr_test);
		for (int i = 0; i < bList.ListSize; i++) {
			System.out.print(bList.pLt[i].data + " ");
		}
	}
}