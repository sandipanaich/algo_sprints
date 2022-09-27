/**
 * Bubble Sort
 */
package week3.algo.sort;

import java.util.Arrays;

public class BubbleSort {

	public static final <T extends Comparable<T>> void sort(T[] array) {

		int size = array.length;
		for (int i = 1; i < size; i++) {
			int j = i;
			while (j > 0 && (array[j - 1].compareTo(array[j]) > 0)) {
				swap(array, j - 1, j);
				j--;
			}
		}
	}

	public static final <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] data = new Integer[] {};
//		Integer[] data = new Integer[] { 1 };
//		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Integer[] data = new Integer[] { 0, 2, 4, 6, 8, 9, 7, 5, 3, 1 };
//		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));

	}

}
