package org.java8;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class IntermediateOperations
{
	public static void main(String[] args)
	{
		Stream<Integer> stream = Stream.of(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9);

//		stream.forEach(System.out::println);

//		Predicate<Integer> predicate = i -> i % 2 == 0;
//		stream.filter(predicate).forEach(System.out::println);

//		Function<Integer, Integer> function = i -> i * i;
//		stream.map(function).forEach(System.out::println);

//		Consumer<Integer> consumer = i -> System.out.println(i * i);
//		stream.forEach(consumer);

//		Supplier<Integer> supplier = () -> 1;
//		Stream.generate(supplier).limit(10).forEach(System.out::println);

//		stream.distinct().forEach(System.out::println);

//		stream.sorted(Comparator.reverseOrder()).forEach(System.out::println);

//		stream.limit(3).forEach(System.out::println);

//		stream.skip(3).forEach(System.out::println);

//		stream.takeWhile(i -> i < 5).forEach(System.out::println);

//		stream.dropWhile(i -> i < 5).forEach(System.out::println);

//		Long start = System.currentTimeMillis();
//		stream
//			.filter(i -> i % 2 == 0)
//			.map(i -> i * i)
//			.distinct()
//			.sorted(Comparator.reverseOrder())
//			.limit(3)
//			.skip(1)
//			.forEach(System.out::println);
//		Long end = System.currentTimeMillis();
//		System.out.println(end - start);

//		Long start = System.currentTimeMillis();
//		stream.parallel()
//			.filter(i -> i % 2 == 0)
//			.map(i -> i * i)
//			.distinct()
//			.sorted(Comparator.reverseOrder())
//			.limit(3)
//			.skip(1)
//			.forEach(System.out::println);
//		Long end = System.currentTimeMillis();
//		System.out.println(end - start);

	}
}
