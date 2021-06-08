/**
 * Selection Sort Implementation.
 */
package week1.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class SelectionSort {

	public static <T extends Comparable<T>> void sort(T[] data) {
		if (data == null)
			return;

		int size = data.length;

		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (less(data[j], data[i]))
					min = j;
			}
			swap(data, i, min);
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

//		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}
