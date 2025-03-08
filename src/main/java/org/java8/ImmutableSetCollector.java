package org.java8;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ImmutableSetCollector<T> implements Collector<T, Set<T>, Set<T>>
{

	@Override
	public Supplier<Set<T>> supplier()
	{
		return HashSet::new; // Creates a mutable HashSet to store elements
	}

	@Override
	public BiConsumer<Set<T>, T> accumulator()
	{
		return Set::add; // Adds elements to the set
	}

	@Override
	public BinaryOperator<Set<T>> combiner()
	{
		return (set1, set2) -> {
			set1.addAll(set2);
			return set1; // Merges two sets in parallel execution
		};
	}

	@Override
	public Function<Set<T>, Set<T>> finisher()
	{
		return Collections::unmodifiableSet; // Converts to an immutable set
	}

	@Override
	public Set<Characteristics> characteristics()
	{
		return Collections.singleton(Characteristics.UNORDERED);
	}

	// Utility method to use in stream operations
	public static <T> Collector<T, Set<T>, Set<T>> toImmutableSet()
	{
		return new ImmutableSetCollector<>();
	}

	public static void main(String[] args)
	{
		List<String> names = List.of("Alice", "Bob", "Charlie", "Alice");

		// Collecting into an immutable set
		Set<String> immutableSet = names.stream().collect(toImmutableSet());

		System.out.println("Immutable Set: " + immutableSet);
	}
}
