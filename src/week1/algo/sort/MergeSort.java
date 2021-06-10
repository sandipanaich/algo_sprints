/**
 * Merge Sort Implementation.
 * Time Complexity: O(n log(n))
 * Best and Worst Casr: O(n log(n))
 * Space Complexity: O(log(n))
 */
package week1.algo.sort;

import java.util.Arrays;

public class MergeSort {

	public static final <T extends Comparable<T>> void sort(T[] data) {

		int length = data.length;

		int low = 0;
		int high = length - 1;

		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Comparable[length];

		mergesort(data, low, high, aux);

	}

	public static final <T extends Comparable<T>> void mergesort(T[] data, int low, int high, T[] aux) {

		if (low < high) {
			int mid = (low + high) / 2;
			mergesort(data, low, mid, aux);
			mergesort(data, mid + 1, high, aux);
			merge(data, low, mid, high, aux);
		}
	}

	public static final <T extends Comparable<T>> void merge(T[] data, int low, int mid, int high, T[] aux) {

		int i = low;
		int j = mid + 1;
		int k = low;

		while (k <= high) {

			if (i > mid)
				aux[k++] = data[j++];
			else if (j > high)
				aux[k++] = data[i++];
			else if (less(data[i], data[j]))
				aux[k++] = data[i++];
			else
				aux[k++] = data[j++];
		}

		System.arraycopy(aux, low, data, low, high - low + 1);
	}

	public static final <T extends Comparable<T>> boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {
//		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}
