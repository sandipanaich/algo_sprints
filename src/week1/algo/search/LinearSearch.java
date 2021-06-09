/**
 * Linear Search Implementation.
 * 
 * Time complexity: O(n)
 * Space Complexity: O(1)
 */
package week1.algo.search;

/**
 * @author Sandipan Aich
 */
public class LinearSearch<T> {

	public static final <T> int search(T[] data, T element) {
		if (data == null || element == null)
			return -1;

		int size = data.length;

		for (int i = 0; i < size; i++) {
			if (data[i] != null && data[i].equals(element))
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		Integer[] data = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for(int i = 0 ; i < 20; i++)
		{
			System.out.println(i + " :: " + search(data, i));
		}
	}

}
