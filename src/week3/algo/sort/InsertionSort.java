/**
 * Insertion Sort Implementation.
 */
package week3.algo.sort;

import java.util.Arrays;

public class InsertionSort {

	public static final <T extends Comparable<T>> void sort(T[] array) {

		int size = array.length;
		int index = 1;

		while (index < size) {

			T current = array[index];
			int prev_index = index - 1;

			while (prev_index >= 0 && current.compareTo(array[prev_index]) < 0) {
				array[prev_index + 1] = array[prev_index];
				prev_index--;
			}
			array[prev_index + 1] = current;
			index++;
		}

	}

	public static void main(String[] args) {
//		Integer[] data = new Integer[] {};
//		Integer[] data = new Integer[] { 1 };
		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));
	}
}