/**
 * Binary Search Implementation.
 */
package week2.algo.search;

/**
 * @author Sandipan Aich
 */
public class BinarySearch {

	public static final <T extends Comparable<T>> int search(T[] data, T element) {
		int size = data.length;

		int low = 0;
		int high = size - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if(data[mid].equals(element))
				return mid;
			
			if(less(element, data[mid]))
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}
	
	public static final <T extends Comparable<T>> boolean less(T one, T two)
	{
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {

		Integer[] data = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < 20; i++)
			System.out.println(i + " :: " + search(data, i));
	}

}
