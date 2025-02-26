package org.java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8
{
	public static void main(String[] args)
	{
		Predicate<String> p = s -> s.length() > 5;
		System.out.println(p.test("hello"));

		Consumer<String> c = s -> System.out.println(s);
		c.accept("hello");

		c.andThen(s -> System.out.println(s + "xxx")).accept("hello");

		Supplier<String> s = () -> "hello";
		System.out.println(s.get());

		Function<String, Integer> f = s1 -> s1.length();

		System.out.println(f.apply("hello"));

		BiFunction<String, String, Integer> bf = (s1, s2) -> s1.length() + s2.length();
		System.out.println(bf.apply("hello", "world"));

		BiConsumer<String, String> bc = (s1, s2) -> System.out.println(s1 + s2);
		bc.accept("hello", "world");

		BinaryOperator<String> bo = (s1, s2) -> s1 + s2;

		BiPredicate<String, String> bp = (s1, s2) -> s1.length() > s2.length();

	}
}
