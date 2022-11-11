package insanity.algo.dynamic.programming.attempt;

public class FibonacciSeries {

	public static final int fibonacci(int num) {

		if (num <= 2)
			return 1;
		int[] array = new int[num];
		
		array[0] = 0;
		array[1] = array[2] = 1;
		
		return fibonacci(num - 1, array);
	}

	private static final int fibonacci(int num, int[] array) {

		if (num < 2)
			return 1;

		return fibonacci(num - 1, array) + fibonacci(num - 2, array);
	}

	public static void main(String[] args) {

		for (int index = 1; index <= 10; index++)
			System.out.println(String.format("fibonnai(%d): %d", index, fibonacci(index)));
	}

}
