package algos.standard.sorting;

public class Search {
	private int[] a;
	private int b;

	Search(int[] a, int b) {
		this.a = a;
		this.b = b;
	}

	public Search(int[] unsortedarray) {
		this.a = unsortedarray;
		this.b = 0;
	}

	public void binarysearch(int[] arr, int start, int end) {
		int arr_len = end - start;
		// System.out.println(arr_len+"arr_len");
		int mid = start + (arr_len) / 2;
		// System.out.println(start+"start");
		// System.out.println(mid+"mid");
		// System.out.println(end+"end");
		if (arr[mid] == b) {
			System.out.println(mid);
		} else if (start == end) {
			System.out.println("No Match");
		} else if (arr[mid] > b) {
			// System.out.println("a");
			binarysearch(arr, start, mid - 1);
		} else if (arr[mid] < b) {
			// System.out.println("b");
			binarysearch(arr, mid + 1, end);
		} else {
			System.out.println("Algo is wrong");
		}
	}

	public void binarysearch_iterative() {
		int hi = a.length - 1;
		int low = 0;
		while (low <= hi) {
			int mid = low + (hi - low) / 2;
			if (a[mid] > b) {
				hi = mid - 1;
			} else if (a[mid] < b) {
				low = mid + 1;
			} else {
				System.out.println(mid);
				break;
			}
		}

	}

	public int[] selectionsort() {
		int len = a.length;
		int lo = 0;
		while (lo < len) {
			int x = min(lo);
			swap(lo, x, a);
			lo = lo + 1;
		}
		return a;
	}

	private void swap(int x, int y, int[] arr) {
		int z = arr[y];
		arr[y] = arr[x];
		arr[x] = z;
		// System.out.println(arr[y]+"swapped"+arr[x]);
	}

	private int min(int start) {

		int x = a[start];
		int x_no = start;
		while (start <= a.length - 1) {
			if (x > a[start]) {
				x = a[start];
				x_no = start;
			}
			start = start + 1;
		}
		return x_no;
	}

	public void bubblesort() {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					swap(j, j + 1, a);
				}
			}
		}
	}

	public void insertionsort() {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				int k = j;
				if (a[k] > a[i]) {
					int z = a[k];
					a[k] = a[i];
					while (k < i) {
						int x = a[k + 1];
						a[k + 1] = z;
						z = x;
						k++;

					}

				}
			}
		}
	}

	public void mergesort(int[] arr, int start, int end) {

		int mid = start + (end - start) / 2;
		if (start < end) {
			mergesort(arr, mid + 1, end);
			mergesort(arr, start, mid);
			merge(arr, start, mid, end);
		}
	}

	void merge(int arr[], int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {

		int[] unsortedarray = { 1, 4, 2, 5, 3, 2, 7, 1, 9, 10 };
		/*
		 * int []sortedarray={1,2,3,4,5,6,7,8,9,10,11,12,13};
		 * 
		 * Search search=new Search(sortedarray,15);
		 * //System.out.println(search.a.length); search.binarysearch(search.a,
		 * 0, search.a.length-1); search.binarysearch_iterative();
		 */

		Search search1 = new Search(unsortedarray);
		// search1.selectionsort();
		// search1.bubblesort();
		// search1.insertionsort();
		search1.mergesort(search1.a, 0, search1.a.length - 1);
		for (int i = 0; i < search1.a.length; i++) {
			System.out.println(search1.a[i]);
		}
	}

}
