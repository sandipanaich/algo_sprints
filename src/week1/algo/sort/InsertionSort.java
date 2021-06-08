/**
 * Insertion Sort Implementation.
 * Time Complexity O(n^2)
 * Space Complexity O(1)
 * Stable: YES
 * Best Case: O(n)
 */
package week1.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class InsertionSort {

	public static final <T extends Comparable<T>> void sort(T[] data) {
		
		if (data == null)
			return;

		int size = data.length;
		for (int i = 1; i < size; i++) {

			T element = data[i];
			int j = i - 1;
			while (j >= 0 && less(element, data[j]))
			{
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = element;
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
