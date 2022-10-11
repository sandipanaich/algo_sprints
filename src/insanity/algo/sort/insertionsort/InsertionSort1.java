package insanity.algo.sort.insertionsort;

import java.util.Arrays;

public class InsertionSort1 {

	public static <T extends Comparable<T>> T[] sort(T[] array) {

		int length = array.length;

		for (int index = 1; index < length; index++) {

			T element = array[index];
			int i = index - 1;

			while (i >= 0 && array[i].compareTo(element) > 0) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = element;
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
