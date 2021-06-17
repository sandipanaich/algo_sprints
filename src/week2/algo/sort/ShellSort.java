/**
 * Shell Sort Implementation.
 * Time Complexity: O(n^2), but faster than Insertion Sort.
 * Space Complexity: O(1)
 * Stable: NO
 */
package week2.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class ShellSort {

	public static <T extends Comparable<T>> void sort(T[] data) {

		int size = data.length;
		int gap = 0;

		for (int i = 1; i < size; i = 3 * gap + 1, gap++)
			;

		while (gap > 0) {
			for (int i = 0, j = gap; j < size; i++, j++) {
				if (less(data[j], data[i]))
					swap(data, i, j);
			}
			gap--;
		}

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

//		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}
