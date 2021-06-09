/**
 * Binary Search Implementation.
 */
package week1.algo.search;

/**
 * @author Sandipan Aich
 */
public class BinarySearch {

	public static final <T extends Comparable<T>> int search(T[] data, T element) {

		if (data == null || element == null)
			return -1;

		int size = data.length;
		int i = 0;
		int j = size - 1;

		while (i <= j) {
			
			int mid = (i + j) / 2;

			if (data[mid] != null && data[mid].equals(element))
				return mid;
			else if (less(data[mid], element))
				i = mid + 1;
			else
				j = mid - 1;
		}

		return -1;
	}

	public static final <T extends Comparable<T>> boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {

		Integer[] data = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < 20; i++)
			System.out.println(i + " :: " + search(data, i));
	}

}
