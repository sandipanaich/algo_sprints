/**
 * Merge Sort Implementation.
 * Time Complexity: O(n log(n))
 * Best and Worst Case: O(n log(n))
 * Space Complexity: O(log(n))
 */
package week2.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class MergeSort {

	public static <T extends Comparable<T>> void sort(T[] data) {
		int size = data.length;
		int last = size - 1;

		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Comparable[size];
		sort(data, 0, last, aux);
	}

	public static <T extends Comparable<T>> void sort(T[] data, int low, int high, T[] aux) {
		if (high > low) {
			int mid = (low + high) / 2;
			sort(data, low, mid, aux);
			sort(data, mid + 1, high, aux);
			merge(data, low, mid, high, aux);
		}
	}

	public static <T extends Comparable<T>> void merge(T[] data, int low, int mid, int high, T[] aux) {

		int k = low;
		int i = low;
		int j = mid + 1;

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

	private static <T extends Comparable<T>> boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {
		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}
