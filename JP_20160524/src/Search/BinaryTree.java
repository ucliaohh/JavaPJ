package Search;

public class BinaryTree {
	public BinaryTree() {
		root = null;
	}

	public class TreeNode { // public ---> for "class Binary" calling
		private int nData;
		private TreeNode lChild;
		private TreeNode rChild;

		public TreeNode(int nData) {
			this.nData = nData;
			this.lChild = null;
			this.rChild = null;
		}

		public int GetNodeValue() {
			return nData;
		}
	}

	private TreeNode root;

	public TreeNode GetRoot() {
		return root;
	}

	public TreeNode BuildTree(int[] arr, int nStart, int nEnd, TreeNode node) {
		if (nStart > nEnd)
			return null;
		int mid = (nStart + nEnd) / 2;
		if (node == null) {
			node = new TreeNode(arr[mid]);
		}

		System.out.print(arr[mid] + " ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		node.lChild = BuildTree(arr, nStart, mid - 1, node.lChild);
		node.rChild = BuildTree(arr, mid + 1, nEnd, node.rChild);

		return node;
	}

	public void BuildTree(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
	}

	public void insert(int nData) {
		root = insert(root, nData);
	}

	public TreeNode insert(TreeNode node, int nData) {
		if (node == null) {
			node = new TreeNode(nData);
		} else {
			if (nData <= node.nData) {
				node.lChild = insert(node.lChild, nData);
			} else {
				node.rChild = insert(node.rChild, nData);
			}
		}
		return node;
	}

	public void TravelTree(TreeNode node) {
		if (node != null) {
			TravelTree(node.lChild);
			System.out.print(node.nData + " ");
			TravelTree(node.rChild);
		}
	}

	public TreeNode SearchTree(TreeNode node, int nTarget) {
		if (node == null)
			return null;
		if (nTarget > node.nData) {
			return SearchTree(node.rChild, nTarget);
		} else if (nTarget < node.nData) {
			return SearchTree(node.lChild, nTarget);
		} else {
			return node;
		}
	}

	public static void main(String[] args) {
		int[] arr_test = { 4, 25, 133, 998, 3555, 7897, 8988, 9011, 9565, 10023 };

		BinaryTree bTree = new BinaryTree();
		bTree.root = bTree.BuildTree(arr_test, 0, arr_test.length - 1,
				bTree.root);

		System.out.println();
		bTree.TravelTree(bTree.root);

		TreeNode node = bTree.SearchTree(bTree.root, 9011);
		System.out.print("\r\n" + node.nData);
	}
}