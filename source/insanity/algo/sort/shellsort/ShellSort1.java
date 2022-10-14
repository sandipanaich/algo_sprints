package insanity.algo.sort.shellsort;

import java.util.Arrays;

public class ShellSort1 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		int len = array.length;
		int gap = len / 2;

		while (gap > 0) {

			for (int i = gap; i < len; i++) {
				int j = i - gap;
				T element = array[i];

				while(j >= 0 && less(element, array[j]))
				{
					array[j+gap] = array[j]; 
					j-=gap;
				}
				array[j + gap] = element;
			}
			gap--;
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
