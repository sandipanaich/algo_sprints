package insanity.algo.sort.insertionsort;

import java.util.Arrays;

public class InsertionSort4 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		int len = array.length;

		for (int i = 1; i < len; i++) {
			T element = array[i];
			int j = i - 1;

			while (j >= 0 && less(element, array[j])) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = element;
		}
		return array;
	}

	private static final <T extends Comparable<T>> boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));

	}
}
