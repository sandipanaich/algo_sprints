/**
 * Quick Sort Implementation.
 * Time Complexity: O(n log(n))
 * Space Complexity: O(log(n))
 */
package week1.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class QuickSort {

	public static final <T extends Comparable<T>> void sort(T[] data) {

		if (data == null)
			return;

		int start = 0;
		int last = data.length - 1;
		quicksort(data, start, last);
	}

	public static final <T extends Comparable<T>> void quicksort(T[] data, int low, int high) {

		if (low >= high)
			return;

		int pivot = partition(data, low, high);
		quicksort(data, low, pivot - 1);
		quicksort(data, pivot + 1, high);
	}

	public static final <T extends Comparable<T>> int partition(T[] data, int low, int high) {

		T element = data[high];
		int i = low;
		int j = high - 1;

		while (i <= j) {
			if (less(data[i], element))
				i++;
			else if (less(element, data[j]))
				j--;
			else {
				swap(data, i, j);
			}
		}
		swap(data, i, high);
		return i;
	}

	private static <T> void swap(T[] data, int i, int j) {

		if (i != j) {

			T temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
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
