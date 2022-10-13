package insanity.algo.sort.insertionsort;

import java.util.Arrays;

public class InsertionSort3 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		if (array == null || array.length <= 1)
			return array;
		int len = array.length;

		for (int i = 1; i < len; i++) {
			T element = array[i];
			int j = i - 1;

			while (j >= 0 && array[j].compareTo(element) > 0) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = element;
		}

		return array;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

}
