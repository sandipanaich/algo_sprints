package insanity.algo.sort.bubblesort;

import java.util.Arrays;

public class BubbleSort1 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

	private static <T extends Comparable<T>> T[] sort(T[] array) {

		final int last = array.length - 1;

		for (int i = last; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0)
					swap(array, j, j + 1);
			}
		}
		return array;
	}

	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
