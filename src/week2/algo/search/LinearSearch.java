/**
 * Linear Search Implementation.
 * 
 * Time complexity: O(n)
 * Space Complexity: O(1)
 */
package week2.algo.search;

/**
 * @author Sandipan Aich
 */
public class LinearSearch<T> {

	public static final <T> int search(T[] data, T element)
	{
		int length = data.length;
		
		for(int i = 0; i < length; i++)
		{
			if(element.equals(data[i]))
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
