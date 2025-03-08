package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class SumOfSquaresCollector
{
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Using the custom collector to compute sum of squares
		int sumOfSquares = numbers.stream().collect(sumOfSquaresCollector());

		System.out.println("Sum of Squares: " + sumOfSquares); // Output: 55
	}

	public static Collector<Integer, int[], Integer> sumOfSquaresCollector()
	{
		return Collector.of(
				// Supplier: Creates a single-element array to hold the sum
				() -> new int[1],

				// Accumulator: Squares each number and adds it to the sum
				(acc, num) -> acc[0] += num * num,

				// Combiner: Merges two accumulators (only needed for parallel streams)
				(acc1, acc2) -> {
					acc1[0] += acc2[0];
					return acc1;
				},

				// Finisher: Extracts the final sum from the array
				acc -> acc[0]
		);
	}
}
