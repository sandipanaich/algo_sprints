package week3.algo.sort;

import java.util.Arrays;

public class SelectionSort {

	public static final <T extends Comparable<T>> void sort(T[] array) {
		int size = array.length;
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
