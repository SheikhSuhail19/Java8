package org.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeJava8Streams
{
	public static void main(String[] args)
	{
		// 🧩 Question 1: Find the First Repeated Character
		// Given a string, find the first character that repeats. If no character repeats, return Optional.empty().
		// Input:  "swiss"
		// Output: Optional[s]
		String s = "swiss";
		Optional<Character> firstRepeatedChar = s.chars()
				.mapToObj(c -> (char) c)
				.filter(c -> s.indexOf(c) != s.lastIndexOf(c))
				.findFirst();
		System.out.println(firstRepeatedChar);

		// 🧩 Question 2: Find the Longest Word
		// Given a string, find the longest word. If no word exists, return Optional.empty().
		// Input:  "The quick brown fox jumps over the lazy dog"
		// Output: Optional[jumps]
		String sentence = "The quick brown fox jumps over the lazy dog";
		Optional<String> longestWord = Arrays.stream(sentence.split(" "))
				.max(Comparator.comparingInt(String::length));
		System.out.println(longestWord);

		// 🧩 Question 3: Find the Second Largest Number
		// Given a list of integers, find the second largest number. If the list is empty, return Optional.empty().
		// Input:  [1, 2, 3, 4, 5]
		// Output: Optional[4]
		Optional<Integer> secondLargestNumber = Arrays.stream(new int[]{1, 2, 3, 4, 5})
				.boxed()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst();
		System.out.println(secondLargestNumber);

		// 🧩 Question 4: Find the Second Smallest Number
		// Given a list of integers, find the second smallest number. If the list is empty, return Optional.empty().
		// Input:  [1, 2, 3, 4, 5]
		// Output: Optional[2]
		Optional<Integer> secondSmallestNumber = Arrays.stream(new int[]{1, 2, 3, 4, 5})
				.boxed()
				.sorted(Comparator.naturalOrder())
				.skip(1)
				.findFirst();
		System.out.println(secondSmallestNumber);

		// 🧩 Question 5: Find the Second Most Common Word
		// Given a string, find the second most common word. If no word exists, return Optional.empty().
		// Input:  "The quick brown fox jumps over the lazy dog"
		// Output: Optional[jumps]
		String sentence2 = "The quick brown fox jumps over the lazy dog";
		Optional<String> secondMostCommonWord = Arrays.stream(sentence2.split(" "))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.skip(1)
				.map(Map.Entry::getKey)
				.findFirst();
		System.out.println(secondMostCommonWord);

		String sentence3 = "The quick brown fox jumps over the lazy dog jumps over the lazy fox";
		Optional<String> secondMostCommonWord2 =
				Arrays.stream(sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"))
						.collect(Collectors.groupingBy(word -> word, Collectors.counting())) // Count occurrences
						.entrySet()
						.stream()
						.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Sort by frequency
						.skip(1) // Get second most common
						.map(Map.Entry::getKey)
						.findFirst();
		System.out.println(secondMostCommonWord2);

		// 🧩 Question 6: Find the Second Most Common Character
		// Given a string, find the second most common character. If no character exists, return Optional.empty().
		// Input:  "The quick brown fox jumps over the lazy dog"
		// Output: Optional[l]

		// 🧩 Question 7: Convert a List of Strings to a Map
		// You have a list of names. Convert it into a Map where the key is the name and the value is its length.
		// Input:  ["Alice", "Bob", "Charlie"]
		// Output: {Alice=5, Bob=3, Charlie=7}
		List<String> names = List.of("Alice", "Bob", "Charlie");
		Map<String, Integer> nameLengthMap = names.stream()
				.collect(Collectors.toMap(name -> name, String::length));
		System.out.println(nameLengthMap);

		Map<String, Integer> nameMap = names.stream()
				.collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(nameMap);

		// 🧩 Question 8: Find the Longest Word in a List
		// Given a list of words, return the longest word. If multiple words have the same length, return any.
		// Input:  ["apple", "banana", "cherry", "blueberry"]
		// Output: "blueberry"
		List<String> words = List.of("apple", "banana", "cherry", "blueberry");
		String longestWord2 = words.stream()
				.max(Comparator.comparingInt(String::length))
				.orElse(null);
		System.out.println(longestWord2);

		// 🧩 Question 9: Sum of Squares of Even Numbers
		// Given a list of numbers, find the sum of squares of even numbers.
		// Input:  [1, 2, 3, 4, 5, 6]
		// Output: 56  // (2² + 4² + 6²) = (4 + 16 + 36)
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		int sumOfSquares = numbers.stream()
				.filter(num -> num % 2 == 0)
				.map(num -> num * num)
				.reduce(0, Integer::sum);
		System.out.println(sumOfSquares);

		// 🧩 Question 10: Find the Second Largest Number in a List
		// Given a list of numbers, find the second largest number. If the list is empty, return Optional.empty().
		// Input:  [1, 2, 3, 4, 5]
		// Output: Optional[4]
		List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);
		Optional<Integer> secondLargestNumber2 = numbers2.stream()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst();
		System.out.println(secondLargestNumber2);

		// 🧩 Question 11: Find the Most Frequent Element in a List
		// Given a list of numbers, find the most frequently occurring element.
		// Input:  [1, 3, 2, 3, 4, 3, 5, 4, 4, 4]
		// Output: 4
		List<Integer> numbers3 = List.of(1, 3, 2, 3, 4, 3, 5, 4, 4, 4);
		Optional<Integer> mostFrequentElement = numbers3.stream()
				.collect(Collectors.groupingBy(num -> num, Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey);
		System.out.println(mostFrequentElement);


		// Problem: Given a list of integers, calculate the sum of all even numbers using Streams.
		List<Integer> numbers4 = List.of(1, 2, 3, 4, 5, 6);
		int sumOfEvenNumbers = numbers4.stream()
				.filter(num -> num % 2 == 0)
				.reduce(0, Integer::sum);

		List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sumOfEvens = numbers5.stream()
				.filter(n -> n % 2 == 0)
				.mapToInt(Integer::intValue)
				.sum();
		System.out.println(sumOfEvens);

		// Problem: Given a list of strings, convert each string to uppercase using Streams.

		List<String> words2 = Arrays.asList("apple", "banana", "cherry");
		List<String> uppercasedWords = words2.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(uppercasedWords);

		// Problem: Identify duplicate elements in a list using Streams.

		List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3);
		Set<Integer> duplicates = numbers6.stream()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		System.out.println(duplicates);

		// Problem: Given a sentence, count the number of occurrences of each word using Streams.
		String sentence4 = "the quick brown fox jumps over the lazy dog the fox was quick";
		Map<String, Long> wordCount = Arrays.stream(sentence4.split(" "))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println(wordCount);

		List<List<Integer>> listOfLists = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8, 9)
		);

		// Problem: Given a list of lists, flatten it into a single list using Streams.

		List<Integer> flattenedList = listOfLists.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
		System.out.println(flattenedList);


		// Problem: Given a list of strings, find the longest string using Streams.

		List<String> words4 = Arrays.asList("apple", "banana", "cherry", "date");
		String longestWord3 = words4.stream()
				.max(Comparator.comparingInt(String::length))
				.orElse(null);
		System.out.println(longestWord3);

		// Problem: Partition a list of integers into even and odd numbers using Streams.

		List<Integer> numbers7 = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> partitioned = numbers7.stream()
				.collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println(partitioned);

		// Problem: Group a list of strings based on their lengths using Streams.

		List<String> words5 = Arrays.asList("a", "bb", "ccc", "dd", "eee", "f");
		Map<Integer, List<String>> groupedByLength = words5.stream()
				.collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength);

		// Problem: Calculate the average of a list of numbers using Streams.

		List<Integer> numbers8 = Arrays.asList(10, 20, 30, 40, 50);
		double average = numbers8.stream()
				.mapToInt(Integer::intValue)
				.average()
				.orElse(0.0);
		System.out.println(average);

		// Problem: Given a list of integers, filter out the prime numbers using Streams.

		List<Integer> numbers9 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> primes = numbers9.stream()
				.filter(PracticeJava8Streams::isPrime)
				.collect(Collectors.toList());
		System.out.println(primes);

	}

	// Helper method to check for prime
	public static boolean isPrime(int number)
	{
		if (number <= 1) return false;
		for (int i = 2; i <= Math.sqrt(number); i++)
		{
			if (number % i == 0) return false;
		}
		return true;
	}

}
