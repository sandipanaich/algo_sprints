/**
 * Bubble Sort Implementation.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) // In-place Algorithm
 * Stable: YES
 */
package week1.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class BubbleSort {

	public static final <T extends Comparable<T>> void sort(T[] data) {
		
		if (data == null)
			return;

		int size = data.length;
		int last = size - 1;
		
		for (int i = last; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				if (less(data[j + 1], data[j]))
					swap(data, j, j + 1);
			}
		}
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
