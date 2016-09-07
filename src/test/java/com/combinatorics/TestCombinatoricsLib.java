package com.combinatorics;

import org.junit.Test;
import org.paukov.combinatorics3.Generator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * goe on 8/6/16.
 */
public class TestCombinatoricsLib {

	//todo http://www.sousites.com/www.bt.no

	//todo: give generator text, and let it learn which is allowed and not
	//todo: evolve generators, by simple rules and input

	@Test
	public void testSimpleCombinations() {
		List<List<String>> combinations = Generator.combination("red", "black", "white", "green", "blue")
			.simple(3)
			.stream()
			.collect(Collectors.<List<String>>toList());
		combinations.stream().forEach(System.out::println);
	}

	@Test
	public void testCombinationsWithRepetition() {
		Generator.combination(new String[]{"apple", "orange"})
			.multi(3)
			.stream()
			.forEach(System.out::println);
	}

	@Test
	public void testSimplePermutations() {
		Generator.permutation("apple", "orange", "cherry")
			.simple()
			.stream()
			.forEach(System.out::println);

		Generator.permutation(1, 1, 2, 2)
			.simple()
			.stream()
			.forEach(System.out::println);
	}

	@Test
	public void testPermutationsWithRepetition() {
		List<List<String>> permutations = Generator
			.permutation("apple", "orange")
			.withRepetitions(3)
			.stream()
			.collect(Collectors.<List<String>>toList());

		permutations.stream().forEach(System.out::println);
	}
}