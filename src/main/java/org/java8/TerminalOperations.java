package org.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations
{
	public static void main(String[] args)
	{
		Stream<Integer> stream = Stream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9);

//		stream.forEach(System.out::println);

//		long count = stream.count();
//		System.out.println("Count: " + count);

//		boolean anyMatch = stream.anyMatch(i -> i % 2 == 0);
//		System.out.println("Any match: " + anyMatch);
//
//		boolean allMatch = stream.allMatch(i -> i % 2 == 0);
//		System.out.println("All match: " + allMatch);

//		boolean noneMatch = stream.noneMatch(i -> i % 2 == 0);
//		System.out.println("None match: " + noneMatch);

//		Optional<Integer> min = stream.min(Comparator.naturalOrder());
//		System.out.println("Min: " + min.get());

//		Optional<Integer> max = stream.max(Comparator.naturalOrder());
//		System.out.println("Max: " + max.get());

//		Optional<Integer> findFirst = stream.findFirst();
//		System.out.println("Find first: " + findFirst.get());

//		Optional<Integer> findAny = stream.findAny();
//		System.out.println("Find any: " + findAny.get());

//		BinaryOperator<Integer> sum = Integer::sum;
//		Optional<Integer> reduce = stream.reduce(sum);
//		System.out.println("Reduce: " + reduce.get());

//		Object[] array = stream.toArray();
//		System.out.println("Array: " + Arrays.toString(array));

//		Integer[] array = stream.toArray(Integer[]::new);
//		System.out.println("Array: " + Arrays.toString(array));

//		IntStream intStream = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9);
//		int[] array = intStream.toArray();
//		System.out.println("Array: " + Arrays.toString(array));

//		int sum = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).sum();
//		System.out.println("Sum: " + sum);
//
//		int max = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).max().getAsInt();
//		System.out.println("Max: " + max);
//
//		int min = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).min().getAsInt();
//		System.out.println("Min: " + min);
//
//		long count = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).count();
//		System.out.println("Count: " + count);
//
//		boolean anyMatch = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).anyMatch(i -> i % 2 == 0);
//		System.out.println("Any match: " + anyMatch);
//
//		boolean allMatch = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).allMatch(i -> i % 2 == 0);
//		System.out.println("All match: " + allMatch);
//
//		boolean noneMatch = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).noneMatch(i -> i % 2 == 0);
//		System.out.println("None match: " + noneMatch);
//
//		int reduce = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, Integer::sum);
//		System.out.println("Reduce: " + reduce);
//
//		int reduce2 = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (a, b) -> a + b * b);
//		System.out.println("Reduce: " + reduce2);
//
//		int reduce3 = IntStream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (a, b) -> a * b);
//		System.out.println("Reduce: " + reduce3);


//		List<Integer> list = stream.peek(System.out::println).toList();
//		System.out.println("List: " + list);

//		List<Integer> list = stream.peek(System.out::println).collect(Collectors.toList());
//		System.out.println("List: " + list);

//		List<Integer> list2 = stream.collect(Collectors.toUnmodifiableList());
//		System.out.println("List: " + list2);

//		IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(i -> i));
//		System.out.println("Summary: " + summary);

//		LongSummaryStatistics longSummary = stream.collect(Collectors.summarizingLong(i -> i));
//		System.out.println("Long summary: " + longSummary);

//		Map<Integer, List<Integer>> map = stream.collect(Collectors.groupingBy(i -> i % 2, Collectors.toList()));
//		System.out.println("Map: " + map);

//		Map<Integer, Set<Integer>> map2 = stream.collect(Collectors.groupingBy(i -> i % 2, Collectors.toSet()));
//		System.out.println("Map: " + map2);

//		Map<Integer, Integer> map3 = stream.distinct().collect(Collectors.toMap(i -> i, i -> i * i));
//		System.out.println("Map: " + map3);

		Stream<String> stringStream = Stream.of("a", "bb", "ccc", "dddd");

//		Map<Integer, String> map4 = stringStream.collect(Collectors.toMap(String::length, i -> i));
//		System.out.println("Map: " + map4);

//		Map<Integer, List<String>> map5 = stringStream.collect(Collectors.groupingBy(String::length));
//		System.out.println("Map: " + map5);

//		Map<Boolean, List<String>> map6 = stringStream.collect(Collectors.partitioningBy(i -> i.length() > 3));
//		System.out.println("Map: " + map6);

//		String joined = stringStream.collect(Collectors.joining(", ", "{- ", " -}"));
//		System.out.println(joined);

//		String result = stream
//				.collect(Collectors.teeing(
//						Collectors.minBy(Comparator.naturalOrder()),   // Collector for minimum
//						Collectors.maxBy(Comparator.naturalOrder()),   // Collector for maximum
//						(Optional<Integer> min, Optional<Integer> max) -> { // Merger function with explicit types
//							return "Min: " + min.orElse(null) + ", Max: " + max.orElse(null);
//						}
//				));
//
//		System.out.println(result);

		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("apple", "banana"),
				Arrays.asList("orange", "grape"),
				Arrays.asList("kiwi")
		);

		// Use flatMap to convert the stream of lists into a stream of individual elements
		List<String> flattenedList = listOfLists.stream()
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());

		// Alternatively, using method reference:
		// List<String> flattenedList = listOfLists.stream()
		//         .flatMap(List::stream)
		//         .collect(Collectors.toList());

		System.out.println(flattenedList);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		String result = numbers.stream().collect(
				Collector.of(
						() -> new StringJoiner(", ", "[", "]"),    // Supplier: creates a new StringJoiner
						(joiner, number) -> joiner.add(number.toString()), // Accumulator: adds each number
						StringJoiner::merge,                        // Combiner: merges two StringJoiners (used in parallel streams)
						StringJoiner::toString                      // Finisher: converts the joiner to a String
				)
		);

		System.out.println(result); // Output: [1, 2, 3, 4, 5]
	}
}
