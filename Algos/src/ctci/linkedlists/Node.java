package ctci.linkedlists;

import java.util.HashMap;

public class Node {
	int data;
	Node next = null;

	public Node(int v) {
		this.data = v;
	}

	public boolean recursivePalindromeCheck(Node ll) {
		Node temp = ll;
		int len = 1;
		while (temp.next != null) {
			temp = temp.next;
			len++;
		}

		return recursivePalindrome(ll, len);

	}

	private boolean recursivePalindrome(Node ll, int len) {
		Node temp = ll;
		if (len == 0) {
			return true;
		} else if (len == 1) {
			return true;
		} else {
			if (recursivePalindrome(ll.next, len - 2)) {
				int i = 1;
				while (i < len) {
					temp = temp.next;
					i++;
				}
				if (ll.data == temp.data) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

	}

	//not done completely
	public Node addtionOfLL(Node h1, Node h2) {
		Node temp = null;
		int carry = 0;
		while (h1 != null && h2 != null) {
			int k = h1.data + h2.data + carry;
			h1.data = k % 10;
			carry = k / 10;
			h1 = h1.next;
			h2 = h2.next;
		}
		return h1;
	}

	public Node partialSort(Node head, int k) {
		Node temp = head;
		Node nll = temp;
		temp = temp.next;
		nll.next = null;
		while (temp != null) {
			Node temp1 = temp;
			temp = temp.next;
			if (temp1.data < k) {
				temp1.next = nll;
				nll = temp1;
			} else {
				temp1.next = null;
				Node t = nll;
				while (t.next != null) {
					t = t.next;
				}
				t.next = temp1;
			}

		}
		return nll;
	}

	public int kFromLastRecursive(Node head, int k) {
		if (head == null)
			return 0;
		int i = kFromLastRecursive(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}
		return i;

	}

	public int kFromLast(Node head, int k) {
		Node end = head;
		Node temp = head;
		int i = 1;
		while (end != null && i < k) {
			end = end.next;
			i++;
		}
		if (end == null)
			return -1;

		while (end.next != null) {
			end = end.next;
			temp = temp.next;
		}
		return temp.data;
	}

	public void deleteDuplicates(Node head) {
		Node temp = head;
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		map.put(temp.data, temp);
		while (temp.next != null) {
			if (map.containsKey(temp.next.data)) {
				temp.next = temp.next.next;
			} else {
				map.put(temp.next.data, temp.next);
				temp = temp.next;
			}
		}
	}

	public void insertNewNode(int v) {
		Node x = new Node(v);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = x;
	}

	public Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return n.next;
		} else {
			while (n.next != null) {
				if (n.next.data == d) {
					n.next = n.next.next;
					return head;
				} else {
					n = n.next;
				}

			}
		}
		return null;

	}

	public void printll(Node head) {
		Node temp = head.next;
		System.out.println(head.data);
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}
