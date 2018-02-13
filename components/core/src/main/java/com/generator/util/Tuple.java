package com.generator.util;

/**
 * NextGen core utils 17.01.17
 */
public class Tuple<F, S> {

	private F first;
	private S second;

	public Tuple(F first, S second) {
		this.first = first;
		this.second = second;
	}

	public F getFirst() {
		return first;
	}

	public S getSecond() {
		return second;
	}

	public void setFirst(F first) {
		this.first = first;
	}

	public void setSecond(S second) {
		this.second = second;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Tuple<?, ?> tuple = (Tuple<?, ?>) o;

		return first.equals(tuple.first) && second.equals(tuple.second);
	}

	@Override
	public int hashCode() {
		int result = first.hashCode();
		result = 31 * result + second.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "[" + first + "," + second + "]";
	}
}