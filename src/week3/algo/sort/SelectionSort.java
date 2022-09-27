/**
 * Selection Sort
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) // In-place Algorithm
 * Stable: NO
 */
package week3.algo.sort;

import java.util.Arrays;

public class SelectionSort {

	public static final <T extends Comparable<T>> void sort(T[] array) {
		int size = array.length;

		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i].compareTo(array[j]) < 0)
					swap(array, i, j);
			}
		}
	}

	private static final <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] data = new Integer[] {};
//		Integer[] data = new Integer[] { 1 };
//		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}
