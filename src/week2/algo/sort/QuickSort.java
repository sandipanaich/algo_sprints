/**
 * Quick Sort Implementation.
 * Time Complexity: O(n log(n))
 * Space Complexity: O(log(n))
 */
package week2.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class QuickSort {

	public static <T extends Comparable<T>> void sort(T[] data) {
		int size = data.length;
		int low = 0;
		int high = size - 1;
		quicksort(data, low, high);
	}

	private static <T extends Comparable<T>> void quicksort(T[] data, int low, int high) {

		if (high > low) {
			int pivot = partition(data, low, high);
			quicksort(data, low, pivot - 1);
			quicksort(data, pivot + 1, high);
		}
	}

	private static <T extends Comparable<T>> int partition(T[] data, int low, int high) {

		int i = low;
		int j = high - 1;

		int pivot = high;
		T element = data[pivot];

		while (i <= j) {

			if (less(data[i], element))
				i++;
			else if (less(element, data[j]))
				j--;
			else {
				swap(data, i, j);
				i++;
				j--;
			}
		}
		swap(data, i, pivot);
		
		return i;
	}

	private static <T> void swap(T[] data, int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static <T extends Comparable<T>> boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {
		Integer[] data = new Integer[] { 8, 10, 3, 2, 1, 50, 40, 30, 20, 4 };
//		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}
