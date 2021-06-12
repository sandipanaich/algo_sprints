/**
 * Heap Sort Implementation.
 * Time Complexity: O(log(n))
 * Space Complexity: O(1) // In-place Algorithm
 * Stable: NO
 */
package week1.algo.sort;

import java.util.Arrays;

import week1.ds.heaps.MaxHeap;

/**
 * @author Sandipan Aich
 */
public class HeapSort {

	public static final <T extends Comparable<T>> void sort(T[] data) {

		if (data == null)
			return;

		int size = data.length;
		int last = size - 1;
		
		MaxHeap<T> heap = new MaxHeap<T>(data);
		
		while(!heap.isEmpty())
		{
			T max = heap.remove();
			data[last] = max;
			last--;
		}		
	}

	public static void main(String[] args) {

//		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));

	}

}
