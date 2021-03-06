package ctci.treeAndGraphs;
//incorrect
public class CompleteBinaryTree {
	Node head;

	public CompleteBinaryTree(Node n) {
		this.head = n;
	}

	public void createNode(Node root, int data, int index) {
		Node newNode;
		int i=1;
		int parent = (index ) / 2;
		// temp=newNode;
		if (root == null) {
			return;
		} else if (root.left == null) {
			newNode = new Node(data);
			root.left = newNode;
		} else if (root.right == null) {
			newNode = new Node(data);
			root.right = newNode;
		} else {
			
			if (parent % 2 == 0) {
				System.out.println("inserting " + data + " at tree "
						+ root.left.data);

				createNode(root.left, data, parent);
			} else {
				System.out.println("inserting " + data + " at tree "
						+ root.right.data);
				createNode(root.right, data, parent);
			}
		}

	}

	public void printTree(Node e) {
		// preorder print
		if (e != null && e.left != null && e.right != null) {
			System.out.println(e.data + " " + e.left.data + " " + e.right.data);
		} else if (e != null && e.left != null) {
			System.out.println(e.data + " " + e.left.data + " " + 0);
		} else if (e != null && e.right != null) {
			System.out.println(e.data + " " + 0 + " " + e.right.data);
		}
		if (e.left != null) {
			printTree(e.left);
		}
		if (e.right != null) {
			printTree(e.right);

		}

	}

	public static void main(String[] args) {
		CompleteBinaryTree bt = new CompleteBinaryTree(new Node(1));
		bt.createNode(bt.head, 2, 2);
		bt.createNode(bt.head, 3, 3);
		bt.createNode(bt.head, 4, 4);
		bt.createNode(bt.head, 5, 5);
		bt.createNode(bt.head, 6, 6);
		bt.createNode(bt.head, 7, 7);
		bt.createNode(bt.head, 13, 13);

		bt.printTree(bt.head);

	}

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			super();
			System.out.println("node inserted " + data);
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node() {
			this(-1, null, null);
		}

		public Node(int d) {
			this(d, null, null);
		}

	}

}
