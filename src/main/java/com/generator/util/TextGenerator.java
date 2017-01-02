package com.generator.util;

import org.paukov.combinatorics3.Generator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * goe on 11/23/16.
 */
public class TextGenerator {

	// generate text: hierarchical, using nodes:
	public static void main(String[] args) {

		// todo use this to make a regexp-generator, which takes text, and evolves methods to regexp them (extract list, tuples etc from any text)
		// evaluates by compression time and recovery errors (how much can it compress, how long does it take to compress and recover, and how accurate is the recovery ?)

//		String[] alphabet = "a b c".split(" ");
//		String[] alphabet = "0 1".split(" ");
//		String[] alphabet = "with a person on without spell".split(" ");
		//String[] alphabet = "BooleanParameter KeyValueListParameter ListParameter StatementParameter StringParameter".split(" ");
//		String[] alphabet = "Positive_Repetition Division Completion Translation Opposition Application Qualification Scale".split(" ");
//		String[] alphabet = "Everyone Someone No-one knows".split(" ");
		String[] alphabet = "x1,x1 x2,y2".split(" ");

		simplecombination(alphabet, 2);
		simplecombination(alphabet, 3);
		simplecombination(alphabet, 4);
		simplecombination(alphabet, 5);
		simplecombination(alphabet, 6);
		simplecombination(alphabet, 7);
		simplecombination(alphabet, 8);

		multicombination(alphabet, 2);

		simplePermutation(alphabet);   // Global space (all coordinates, Universe)
		subsets(alphabet);              // all subspaces of Global space)

		multiPermutation(alphabet, 2);

//		Generator.partition(5)
//			.stream()
//			.forEach(System.out::println);

		System.out.println("Done");
	}


	/*
		A simple k-combination of a finite set S is a subset of k distinct elements of S. Specifying a subset does not arrange them in a particular order.
      As an example, a poker hand can be described as a 5-combination of cards from a 52-card deck: the 5 cards of the hand are all distinct, and the order of the cards in the hand does not matter.
		*/
	private static void simplecombination(String[] alphabet, int k) {
		System.out.println("Simple combination. " + k + " distinct elements of " + Arrays.asList(alphabet));
		Generator.combination(alphabet)
			.simple(k)
			.stream()
			.forEach(System.out::println);
	}

	/*
		A k-multicombination or k-combination with repetition of a finite set S is given by a sequence of k not necessarily distinct elements of S, where order is not taken into account.
		As an example. Suppose there are 2 types of fruits (apple and orange) at a grocery store, and you want to buy 3 pieces of fruit. You could select
			(apple, apple, apple)
			(apple, apple, orange)
			(apple, orange, orange)
			(orange, orange, orange)
		*/
	private static void multicombination(String[] alphabet, int k) {
		System.out.println(k + "-combination with repetition over " + Arrays.asList(alphabet));
		Generator.combination(alphabet)
			.multi(k)
			.stream()
			.forEach(System.out::println);
	}

	/*
		A permutation is an ordering of a set in the context of all possible orderings.
		For example, the set containing the first three digits, 123, has six permutations: 123, 132, 213, 231, 312, and 321.
		*/
	private static void simplePermutation(String[] alphabet) {
		System.out.println("permutations of all possible orderings of " + Arrays.asList(alphabet));
		Generator.permutation(alphabet)
			.simple()
			.stream()
			.forEach(System.out::println);
	}

	/**
	 * Permutation may have more elements than slots
	 */
	private static void multiPermutation(String[] alphabet, int repetitions) {
		System.out.println(repetitions + "-permutations of orderings of " + Arrays.asList(alphabet));
		final List<List<String>> permutations = Generator
			.permutation(alphabet)
			.withRepetitions(repetitions)
			.stream()
			.collect(Collectors.<List<String>>toList());

		permutations.stream().forEach(System.out::println);
	}

	/**
	 * A set A is a subset of a set B if A is "contained" inside B. A and B may coincide. The relationship of one set being a subset of another is called inclusion or sometimes containment.
	 */
	private static void subsets(String[] alphabet) {
		System.out.println("Subsets of " + Arrays.asList(alphabet));
		List<List<String>> subsets = Generator
			.subset(alphabet)
			.simple()
			.stream()
			.collect(Collectors.<List<String>>toList());
		subsets.stream().forEach(System.out::println);
	}
}