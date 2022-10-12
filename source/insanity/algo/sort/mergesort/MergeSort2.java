package insanity.algo.sort.mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort2 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		int length = array.length;
		int last = length - 1;
		T[] sub = (T[]) Array.newInstance(array[0].getClass(), length);

		return sort(array, sub, 0, last);
	}

	private static final <T extends Comparable<T>> T[] sort(T[] array, T[] sub, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			sort(array, sub, left, mid);
			sort(array, sub, mid + 1, right);
			merge(array, sub, left, mid, right);
		}
		return array;
	}

	private static final <T extends Comparable<T>> void merge(T[] array, T[] sub, int left, int mid, int right) {

		int i = left;
		int j = mid + 1;
		int index = left;

		while (true) {
			if (i > mid && j > right)
				break;
			else if (i > mid)
				sub[index++] = array[j++];
			else if (j > right)
				sub[index++] = array[i++];
			else if (array[i].compareTo(array[j]) < 0)
				sub[index++] = array[i++];
			else
				sub[index++] = array[j++];
		}

		for (index = left; index <= right; index++)
			array[index] = sub[index];
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

}
